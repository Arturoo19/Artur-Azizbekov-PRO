import time
import random

def patata_caliente():

    tiempo_limite = random.randint(8, 15)  
    numero = random.randint(1, 100)

    print(f"Tienes {tiempo_limite} segundos para adivinar el número entre 1 y 100.")

    
    inicio = time.time()

    while True:
        
        if time.time() - inicio >= tiempo_limite:
            print(f"Se termino el tiempo. El numero era {numero}.")
            break

        try:
            intento = int(input("Adivina el número: "))
        except ValueError:
            print("Introduce un numero")
            continue

        if intento == numero:
            print("Has adivinado")
            break
        elif intento < numero:
            print("El numero es mayor.")
        else:
            print("El nuero es menor.")

patata_caliente()
