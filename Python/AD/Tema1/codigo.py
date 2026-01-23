# ---------------------------------------------------------
# TUTORIAL DE FICHEROS EN PYTHON
# Punto 1.3.1: Funcionamiento básico de los ficheros
# ---------------------------------------------------------
# Este programa muestra cómo:
#  1. Abrir y leer un fichero (palabras.txt)
#  2. Procesar la información
#  3. Escribir resultados en otros ficheros (salida.txt, salida2.txt)
# ---------------------------------------------------------

from collections import Counter

print("=== TUTORIAL: MANEJO DE FICHEROS EN PYTHON ===\n")

# Paso 1: Apertura y lectura del fichero de entrada
print("1️⃣ Abriendo el fichero 'palabras.txt' en modo lectura...")
with open("palabras.txt", "r", encoding="utf-8") as f:
    contenido = f.read().split()
print("   ✅ Fichero leído correctamente.")
print(f"   Contenido (primeras palabras): {contenido[:10]}...\n")

# Paso 2: Procesamiento de datos
print("2️⃣ Procesando el contenido...\n")

# Contar palabras
total_palabras = len(contenido)
print(f"   ➤ Número total de palabras: {total_palabras}")

# Contar vocales
vocales = sum(letra.lower() in "aeiouáéíóú" for palabra in contenido for letra in palabra)
print(f"   ➤ Número total de vocales: {vocales}")

# Contar repeticiones
contador = Counter(contenido)
palabras_repetidas = {p: c for p, c in contador.items() if c > 1}
max_repeticiones = max(contador.values())
palabras_mas_repetidas = [p for p, c in contador.items() if c == max_repeticiones]

print("   ➤ Palabras que se repiten:")
for palabra, cantidad in sorted(palabras_repetidas.items()):
    print(f"      {palabra}: {cantidad}")

print(f"\n   ➤ Palabra(s) más repetida(s): {', '.join(palabras_mas_repetidas)} ({max_repeticiones} veces)\n")

# Paso 3: Escritura en nuevos ficheros
print("3️⃣ Escribiendo los resultados en 'salida.txt' y 'salida2.txt'...\n")

# Contenido de salida.txt
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

# Contenido de salida2.txt (solo repeticiones y máximas)
salida2 = ["Palabras que se repiten y su frecuencia:"]
for palabra, cantidad in sorted(palabras_repetidas.items()):
    salida2.append(f"{palabra}: {cantidad}")
salida2.append(f"\nPalabra(s) que más se repiten ({max_repeticiones} veces): {', '.join(palabras_mas_repetidas)}")

with open("salida2.txt", "w", encoding="utf-8") as f:
    f.write("\n".join(salida2))

# Paso 4: Confirmación final
print("✅ Proceso completado con éxito.")
print("   Los resultados se han guardado en:")
print("   - salida.txt (todo el análisis)")
print("   - salida2.txt (solo repeticiones)\n")

print("=== FIN DEL TUTORIAL ===")
