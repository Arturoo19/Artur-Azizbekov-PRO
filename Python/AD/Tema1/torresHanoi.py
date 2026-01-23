def torres_hanoi(n, origen, destino, auxiliar):
    if n == 1:
        print(f"Mover disco 1 de {origen} a {destino}")
    else:
        torres_hanoi(n - 1, origen, auxiliar, destino)
        print(f"Mover disco {n} de {origen} a {destino}")
        torres_hanoi(n - 1, auxiliar, destino, origen)


discos = int(input("Introduce el número de discos: "))

movimientos_minimos = 2 ** discos - 1
print(f"\nNúmero mínimo de movimientos: {movimientos_minimos}\n")

torres_hanoi(discos, "Origen", "Destino", "Auxiliar")
