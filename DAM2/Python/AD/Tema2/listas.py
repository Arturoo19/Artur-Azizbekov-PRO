# ============================================
# SIMULACIÓN DE LISTAS CON PUNTEROS EN PYTHON
# Autor: Artur Azizbekov
# ============================================

# ---------- CREAR NODO ----------
def crear_nodo(valor, siguiente=99, anterior=0):
    return {
        "valor": valor,
        "siguiente": siguiente,
        "anterior": anterior
    }

# ---------- CREAR LISTA ----------
def crear_lista(tipo):
    return {
        "tipo": tipo,          # enlazada, enlazada_d, circular, circular_d
        "nodos": {},
        "inicio": 0,
        "fin": 99
    }

# ---------- INSERTAR AL INICIO ----------
def insertar_inicio(lista, valor):
    if not (1 <= valor <= 98):
        return

    nuevo_id = len(lista["nodos"]) + 1
    nuevo = crear_nodo(valor)

    if lista["inicio"] == 0:
        lista["inicio"] = nuevo_id
        lista["fin"] = nuevo_id
        if "circular" in lista["tipo"]:
            nuevo["siguiente"] = nuevo_id
            nuevo["anterior"] = nuevo_id
    else:
        nuevo["siguiente"] = lista["inicio"]
        lista["nodos"][lista["inicio"]]["anterior"] = nuevo_id
        lista["inicio"] = nuevo_id

        if "circular" in lista["tipo"]:
            nuevo["anterior"] = lista["fin"]
            lista["nodos"][lista["fin"]]["siguiente"] = nuevo_id

    lista["nodos"][nuevo_id] = nuevo

# ---------- INSERTAR AL FINAL ----------
def insertar_final(lista, valor):
    if lista["inicio"] == 0:
        print("Lista vacía, no se puede insertar al final")
        return

    nuevo_id = len(lista["nodos"]) + 1
    nuevo = crear_nodo(valor, 99, lista["fin"])

    lista["nodos"][lista["fin"]]["siguiente"] = nuevo_id
    lista["fin"] = nuevo_id

    if "circular" in lista["tipo"]:
        nuevo["siguiente"] = lista["inicio"]
        lista["nodos"][lista["inicio"]]["anterior"] = nuevo_id

    lista["nodos"][nuevo_id] = nuevo

# ---------- INSERTAR ENTRE NODOS ----------
def insertar_nodo(lista, valor, ref):
    if ref not in lista["nodos"]:
        print("Nodo de referencia no existe")
        return

    nuevo_id = len(lista["nodos"]) + 1
    sig = lista["nodos"][ref]["siguiente"]

    nuevo = crear_nodo(valor, sig, ref)
    lista["nodos"][ref]["siguiente"] = nuevo_id

    if sig != 99:
        lista["nodos"][sig]["anterior"] = nuevo_id
    else:
        lista["fin"] = nuevo_id

    lista["nodos"][nuevo_id] = nuevo

# ---------- CONTAR NODOS ----------
def contar_nodos(lista):
    return len(lista["nodos"])

# ---------- BUSCAR NODO ----------
def buscar_nodo(lista, valor):
    for nodo in lista["nodos"].values():
        if nodo["valor"] == valor:
            return True
    return False

# ---------- ELIMINAR NODO ----------
def eliminar_nodo(lista, valor):
    for k, nodo in list(lista["nodos"].items()):
        if nodo["valor"] == valor:
            ant = nodo["anterior"]
            sig = nodo["siguiente"]

            if ant != 0 and ant in lista["nodos"]:
                lista["nodos"][ant]["siguiente"] = sig
            else:
                lista["inicio"] = sig

            if sig != 99 and sig in lista["nodos"]:
                lista["nodos"][sig]["anterior"] = ant
            else:
                lista["fin"] = ant

            del lista["nodos"][k]
            print("Nodo eliminado")
            return
    print("Nodo no encontrado")

# ---------- IMPRIMIR VALORES ----------
def imprimir_valor_lista(lista):
    if lista["inicio"] == 0:
        print("Lista vacía")
        return

    actual = lista["inicio"]
    visitados = set()

    while actual not in visitados:
        visitados.add(actual)
        print(lista["nodos"][actual]["valor"], end=" -> ")
        actual = lista["nodos"][actual]["siguiente"]
        if actual == 99:
            break
    print("NULL")

# ---------- IMPRIMIR LISTA COMPLETA ----------
def imprimir_lista_completa(lista):
    for k, nodo in lista["nodos"].items():
        print(f"ID:{k} | Valor:{nodo['valor']} | Ant:{nodo['anterior']} | Sig:{nodo['siguiente']}")

# ---------- IMPRIMIR AL REVÉS ----------
def imprimir_reves(lista):
    if lista["fin"] == 99 or lista["fin"] == 0:
        print("Lista vacía")
        return

    actual = lista["fin"]
    visitados = set()

    while actual not in visitados:
        visitados.add(actual)
        print(lista["nodos"][actual]["valor"], end=" <- ")
        actual = lista["nodos"][actual]["anterior"]

        if actual == 0:
            break

    print("NULL")


# ---------- COPIAR LISTA A FICHERO ----------
def copiar_lista(lista):
    nombre = f"lista_{lista['tipo']}.txt"
    with open(nombre, "w") as f:
        for k, nodo in lista["nodos"].items():
            f.write(f"ID:{k} Valor:{nodo['valor']} Ant:{nodo['anterior']} Sig:{nodo['siguiente']}\n")
    print(f"Lista copiada en {nombre}")

# ---------- ORDENAR LISTA (EXTRA) ----------
def ordenar_lista(lista):
    valores = sorted(n["valor"] for n in lista["nodos"].values())
    tipo = lista["tipo"]
    lista.clear()
    lista.update(crear_lista(tipo))
    for v in valores:
        if lista["inicio"] == 0:
            insertar_inicio(lista, v)
        else:
            insertar_final(lista, v)

# ---------- EJEMPLO DE USO ----------
if __name__ == "__main__":
    lista = crear_lista("circular_d")

    insertar_inicio(lista, 10)
    insertar_final(lista, 30)
    insertar_nodo(lista, 20, 1)

    imprimir_valor_lista(lista)
    imprimir_lista_completa(lista)
    imprimir_reves(lista)

    ordenar_lista(lista)
    copiar_lista(lista)
