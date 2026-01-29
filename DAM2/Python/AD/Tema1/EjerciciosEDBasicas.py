for i in range(1,11):
    for e in range(1,11):
        print(f"{i} *{e} = {i*e}")
        
    print()


#ej2
altura = int(input("Introduce la altura de triangulo:"))
for i in range(1,altura+1):
    print("*"*i)

#ej3
n = int(input("Introduce un número: "))
for i in range(n):
    for j in range(1, n + 1):
        print(j, end="")
    print()

#ej4a
n1 = int(input("Introduce un número: "))
for i in range (n1):
    for j in range(1,n1+1):
        print("0", end="")
    print()

#ej4b
n = int(input("Introduce el tamaño de la matriz: "))
num = 1
for i in range(n):
    for j in range(n):
        print(num, end="")
        num += 2
    print()

#ej4c
n = int(input("Introduce el tamaño de la matriz: "))
matriz = []

for i in range(n):
    fila = []
    for j in range(n):
        valor = int(input(f"Introduce el valor para la posición [{i}][{j}]: "))
        fila.append(valor)
    matriz.append(fila)

print("\nMatriz introducida:")
for fila in matriz:
    print(fila)

#ej5
n = int(input("Introduce el tamaño de las matrices: "))

print("Introduce los valores de la primera matriz:")
matriz1 = [[int(input(f"M1[{i}][{j}]: ")) for j in range(n)] for i in range(n)]

print("\nIntroduce los valores de la segunda matriz:")
matriz2 = [[int(input(f"M2[{i}][{j}]: ")) for j in range(n)] for i in range(n)]

# Suma de matrices
matriz_suma = [[matriz1[i][j] + matriz2[i][j] for j in range(n)] for i in range(n)]

print("\nResultado de la suma:")
for fila in matriz_suma:
    print(fila)

#ej6
n = int(input("Introduce el tamaño de la matriz: "))
for i in range(n):
    for j in range(n):
        print(i + j, end="")
    print()

#ej7
while True:
    altura = int(input("Introduce la altura del rombo (impar): "))
    if altura % 2 != 0:
        break
    print("La altura debe ser un número impar.")

mitad = altura // 2

# Parte superior
for i in range(mitad + 1):
    print(" " * (mitad - i) + "*" * (2 * i + 1))

# Parte inferior
for i in range(mitad - 1, -1, -1):
    print(" " * (mitad - i) + "*" * (2 * i + 1))

#ej8
matriz = [
    [1, 2, 3, 4, 5],
    [6, 7, 8, 9, 10],
    [11, 12, 13, 14, 15],
    [16, 17, 18, 19, 20],
    [21, 22, 23, 24, 25]
]

n = len(matriz)
principal = sum(matriz[i][i] for i in range(n))
secundaria = sum(matriz[i][n - 1 - i] for i in range(n))

repetir = input("¿Deseas contar el elemento central dos veces? (s/n): ").lower()
if repetir == "s":
    total = principal + secundaria
else:
    total = principal + secundaria - matriz[n // 2][n // 2]

print(f"Suma de diagonales = {total}")

#ej9
n = int(input("Introduce el tamaño de la matriz cuadrada: "))
matriz = []

for i in range(n):
    fila = []
    for j in range(n):
        valor = int(input(f"Introduce el valor para la posición [{i}][{j}]: "))
        fila.append(valor)
    matriz.append(fila)

principal = sum(matriz[i][i] for i in range(n))
secundaria = sum(matriz[i][n - 1 - i] for i in range(n))

repetir = input("¿Deseas contar el elemento central dos veces? (s/n): ").lower()
if repetir == "s":
    total = principal + secundaria
else:
    total = principal + secundaria - matriz[n // 2][n // 2]

print(f"Suma de diagonales = {total}")
