# ============================================
# PILA IMPLEMENTADA MEDIANTE LISTA ENLAZADA
# Autor: Artur Azizbekov
# ============================================

# ---------- CREAR NODO ----------
def crear_nodo(valor, siguiente=None):
    return {
        "valor": valor,
        "siguiente": siguiente
    }

# ---------- CREAR PILA ----------
def crear_pila():
    return {
        "tope": None
    }

# ---------- PILA VACÍA ----------
def pila_vacia(pila):
    return pila["tope"] is None

# ---------- APILAR ----------
def apilar(pila, valor):
    nuevo = crear_nodo(valor, pila["tope"])
    pila["tope"] = nuevo
    print("Elemento apilado correctamente")

# ---------- DESAPILAR ----------
def desapilar(pila):
    if pila_vacia(pila):
        print("La pila está vacía")
        return None

    valor = pila["tope"]["valor"]
    pila["tope"] = pila["tope"]["siguiente"]
    print(f"Elemento desapilado: {valor}")
    return valor

# ---------- TOPE ----------
def tope(pila):
    if pila_vacia(pila):
        print("La pila está vacía")
    else:
        print("Tope de la pila:", pila["tope"]["valor"])

# ---------- IMPRIMIR PILA ----------
def imprimir_pila(pila):
    if pila_vacia(pila):
        print("La pila está vacía")
        return

    actual = pila["tope"]
    print("Pila (tope -> base):")
    while actual:
        print(actual["valor"])
        actual = actual["siguiente"]

# ---------- CONTAR ELEMENTOS ----------
def contar(pila):
    contador = 0
    actual = pila["tope"]
    while actual:
        contador += 1
        actual = actual["siguiente"]
    print("Número de elementos:", contador)
    return contador

# ---------- COPIAR PILA ----------
def copiar_pila(pila_origen):
    pila_aux = crear_pila()
    pila_destino = crear_pila()

    actual = pila_origen["tope"]
    while actual:
        apilar(pila_aux, actual["valor"])
        actual = actual["siguiente"]

    actual = pila_aux["tope"]
    while actual:
        apilar(pila_destino, actual["valor"])
        actual = actual["siguiente"]

    print("Pila copiada correctamente")
    return pila_destino

# ---------- INVERTIR PILA ----------
def invertir_pila(pila):
    pila_invertida = crear_pila()
    actual = pila["tope"]

    while actual:
        apilar(pila_invertida, actual["valor"])
        actual = actual["siguiente"]

    print("Pila invertida creada")
    return pila_invertida

# ---------- VACIAR PILA ----------
def vaciar_pila(pila):
    pila["tope"] = None
    print("Pila vaciada completamente")

# ---------- GUARDAR PILA EN FICHERO ----------
def guardar_pila(pila, nombre_fichero="pila_coches.txt"):
    with open(nombre_fichero, "w") as f:
        f.write("Contenido de la pila (tope -> base):\n")
        actual = pila["tope"]
        while actual:
            f.write(actual["valor"] + "\n")
            actual = actual["siguiente"]

    print(f"Pila guardada en el fichero {nombre_fichero}")

# ---------- MENÚ ----------
def menu():
    pila = crear_pila()

    while True:
        print("\n--- MENÚ PILA DE COCHES ---")
        print("1. Apilar coche")
        print("2. Desapilar coche")
        print("3. Mostrar tope")
        print("4. Imprimir pila")
        print("5. Contar elementos")
        print("6. Copiar pila")
        print("7. Invertir pila")
        print("8. Vaciar pila")
        print("9. Guardar pila en fichero")
        print("0. Salir")

        opcion = input("Elige una opción: ")

        if opcion == "1":
            marca = input("Introduce marca de coche: ")
            apilar(pila, marca)

        elif opcion == "2":
            desapilar(pila)

        elif opcion == "3":
            tope(pila)

        elif opcion == "4":
            imprimir_pila(pila)

        elif opcion == "5":
            contar(pila)

        elif opcion == "6":
            copia = copiar_pila(pila)
            print("Pila copiada:")
            imprimir_pila(copia)

        elif opcion == "7":
            invertida = invertir_pila(pila)
            print("Pila invertida:")
            imprimir_pila(invertida)

        elif opcion == "8":
            vaciar_pila(pila)

        elif opcion == "9":
            guardar_pila(pila)

        elif opcion == "0":
            print("Saliendo del programa...")
            break

        else:
            print("Opción incorrecta")

# ---------- PROGRAMA PRINCIPAL ----------
if __name__ == "__main__":
    menu()
