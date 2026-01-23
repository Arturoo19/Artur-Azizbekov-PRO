# Ejercicio 1
frutas = ["manzana", "uva","kiwi", "platano", "naranja"]
print("Lista completa:", frutas)
print("Primera fruta:", frutas[0])
print("Ultima fruta:", frutas[-1])

# Ejercicio 2
numeros = []
numeros.append(10)
numeros.append(20)
numeros.append(30)
del numeros[1]
print("Lista final:", numeros)

# Ejercicio 3
numeros = [1, 2, 3, 4, 5]
for n in numeros:
    print(n * 2)

# Ejercicio 4
palabras = ["manzana", "uva", "naranja"]
buscar = input("Introduce una palabra: ")
if buscar in palabras:
    print("La palabra está en la lista.")
else:
    print("La palabra no está en la lista.")

# Ejercicio 5
numeros = [1,2,3,4,5,6,7,8,9,10]
print("Primeros 3:", numeros[:3])
print("Ultimos 3:", numeros[-3:])
print("De posición 3 a 7:", numeros[3:8])

