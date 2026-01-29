from collections import Counter

with open("palabras.txt","r",encoding="utf-8") as f:
    contenido = f.read().split()

total_palabras = len(contenido)

vocales = sum(letra.lower() in "aeiouáéíóú" for palabra in contenido for letra in palabra)


contador = Counter(contenido)
palabras_repetidas = {p: c for p, c in contador.items() if c > 1}


max_repeticiones = max(contador.values())
palabras_mas_repetidas = [p for p, c in contador.items() if c == max_repeticiones]

salida = [
    f"Número total de palabras: {total_palabras}",
    f"Número total de vocales: {vocales}",
    "\nPalabras que se repiten y su frecuencia:"
]

for palabra, cantidad in sorted(palabras_repetidas.items()):
    salida.append(f"{palabra}: {cantidad}")

salida.append(f"\nPalabra(s) que más se repiten ({max_repeticiones} veces): {', '.join(palabras_mas_repetidas)}")


with open("salida.txt", "w", encoding="utf-8") as f:
    f.write("\n".join(salida))

salida2 = ["Palabras que se repiten y su frecuencia:"]
for palabra, cantidad in sorted(palabras_repetidas.items()):
    salida2.append(f"{palabra}: {cantidad}")
salida2.append(f"\nPalabra(s) que más se repiten ({max_repeticiones} veces): {', '.join(palabras_mas_repetidas)}")

with open("salida2.txt", "w", encoding="utf-8") as f:
    f.write("\n".join(salida2))



print("\n".join(salida))
print("\nLos resultados se han guardado en 'salida.txt' y 'salida2.txt'.")