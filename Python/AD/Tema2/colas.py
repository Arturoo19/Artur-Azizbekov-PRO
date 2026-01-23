# ============================================
# COLA IMPLEMENTADA MEDIANTE LISTA ENLAZADA
# Autor: Artur Azizbekov
# ============================================

# ---------- CREAR NODO ----------
def crear_nodo(valor):
    return {
        "valor": valor,
        "siguiente": None
    }

# ---------- CREAR COLA ----------
def crear_cola():
    return {
        "frente": None,
        "final": None
    }

# ---------- COLA VACÍA ----------
def cola_vacia(cola):
    return cola["frente"] is None

# ---------- ENCOLAR ----------
def encolar(cola, valor):
    nuevo = crear_nodo(valor)

    if cola_vacia(cola):
        cola["frente"] = nuevo
        cola["final"] = nuevo
    else:
        cola["final"]["siguiente"] = nuevo
        cola["final"] = nuevo

    print("Elemento encolado correctamente")

# ---------- DESENCOLAR ----------
def desencolar(cola):
    if cola_vacia(cola):
        print("La cola está vacía")
        return None

    valor = cola["frente"]["valor"]
    cola["frente"] = cola["frente"]["siguiente"]

    if cola["frente"] is None:
        cola["final"] = None

    print(f"Elemento desencolado: {valor}")
    return valor

# ---------- FRENTE ----------
def frente(cola):
    if cola_vacia(cola):
        print("La cola está vacía")
    else:
        print("Elemento en el frente:", cola["frente"]["valor"])

# ---------- IMPRIMIR COLA ----------
def imprimir_cola(cola):
    if cola_vacia(cola):
        print("La cola está vacía")
        return

    actual = cola["frente"]
    print("Cola (frente -> final):")
    while actual:
        print(actual["valor"])
        actual = actual["siguiente"]

# ---------- CONTAR ELEMENTOS ----------
def contar(cola):
    contador = 0
    actual = cola["frente"]

    while actual:
        contador += 1
        actual = actual["siguiente"]

    print("Número de elementos:", contador)
    return contador

# ---------- COPIAR COLA ----------
def copiar_cola(cola_origen):
    cola_destino = crear_cola()
    actual = cola_origen["frente"]

    while actual:
        encolar(cola_destino, actual["valor"])
        actual = actual["siguiente"]

    print("Cola copiada correctamente")
    return cola_destino

# ---------- INVERTIR COLA ----------
def invertir_cola(cola):
    cola_invertida = crear_cola()
    pila_aux = []

    actual = cola["frente"]
    while actual:
        pila_aux.append(actual["valor"])
        actual = actual["siguiente"]

    while pila_aux:
        encolar(cola_invertida, pila_aux.pop())

    print("Cola invertida creada")
    return cola_invertida

# ---------- VACIAR COLA ----------
def vaciar_cola(cola):
    cola["frente"] = None
    cola["final"] = None
    print("Cola vaciada completamente")

# ---------- GUARDAR COLA ----------
def guardar_cola(cola, nombre_fichero="cola_animales.txt"):
    with open(nombre_fichero, "w") as f:
        f.write("Contenido de la cola (frente -> final):\n")
        actual = cola["frente"]
        while actual:
            f.write(actual["valor"] + "\n")
            actual = actual["siguiente"]

    print(f"Cola guardada en el fichero {nombre_fichero}")

# ---------- MENÚ ----------
def menu():
    cola = crear_cola()

    while True:
        print("\n--- MENÚ COLA DE ANIMALES VERTEBRADOS ---")
        print("1. Encolar animal")
        print("2. Desencolar animal")
        print("3. Mostrar frente")
        print("4. Imprimir cola")
        print("5. Contar elementos")
        print("6. Copiar cola")
        print("7. Invertir cola")
        print("8. Vaciar cola")
        print("9. Guardar cola en fichero")
        print("0. Salir")

        opcion = input("Elige una opción: ")

        if opcion == "1":
            animal = input("Introduce un animal vertebrado: ")
            encolar(cola, animal)

        elif opcion == "2":
            desencolar(cola)

        elif opcion == "3":
            frente(cola)

        elif opcion == "4":
            imprimir_cola(cola)

        elif opcion == "5":
            contar(cola)

        elif opcion == "6":
            copia = copiar_cola(cola)
            print("Cola copiada:")
            imprimir_cola(copia)

        elif opcion == "7":
            invertida = invertir_cola(cola)
            print("Cola invertida:")
            imprimir_cola(invertida)

        elif opcion == "8":
            vaciar_cola(cola)

        elif opcion == "9":
            guardar_cola(cola)

        elif opcion == "0":
            print("Saliendo del programa...")
            break

        else:
            print("Opción incorrecta")

# ---------- PROGRAMA PRINCIPAL ----------
if __name__ == "__main__":
    menu()
