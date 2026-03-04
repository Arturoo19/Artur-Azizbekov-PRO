import heapq
import sqlite3
import csv
import os

# ===============================
# BASE DE DATOS
# ===============================

def conectar():
    base_dir = os.path.dirname(__file__)
    ruta_bd = os.path.join(base_dir, "database.db")
    return sqlite3.connect(ruta_bd)


def inicializar_bd():
    conn = conectar()
    cur = conn.cursor()

    cur.execute("""
    CREATE TABLE IF NOT EXISTS aristas (
        origen TEXT,
        destino TEXT,
        coste REAL
    )
    """)

    cur.execute("""
    CREATE TABLE IF NOT EXISTS historico (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        origen TEXT,
        destino TEXT,
        coste REAL,
        alternativa INTEGER,
        fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    )
    """)

    conn.commit()
    conn.close()


def cargar_csv(ruta):
    conn = conectar()
    cur = conn.cursor()

    with open(ruta, newline="") as f:
        lector = csv.reader(f)
        next(lector)
        for origen, destino, coste in lector:
            cur.execute(
                "INSERT INTO aristas (origen, destino, coste) VALUES (?, ?, ?)",
                (origen, destino, float(coste))
            )

    conn.commit()
    conn.close()


def obtener_aristas():
    conn = conectar()
    cur = conn.cursor()
    cur.execute("SELECT origen, destino, coste FROM aristas")
    datos = cur.fetchall()
    conn.close()
    return datos


def guardar_historico(origen, destino, coste, alternativa):
    conn = conectar()
    cur = conn.cursor()
    cur.execute("""
        INSERT INTO historico (origen, destino, coste, alternativa)
        VALUES (?, ?, ?, ?)
    """, (origen, destino, coste, alternativa))
    conn.commit()
    conn.close()


# ===============================
# GRAFO
# ===============================

def crear_grafo():
    return {}


def agregar_arista(grafo, origen, destino, coste):
    if origen not in grafo:
        grafo[origen] = []
    grafo[origen].append((destino, coste))


# ===============================
# DIJKSTRA
# ===============================

def dijkstra(grafo, origen, destino):
    cola = [(0, origen)]
    distancias = {origen: 0}
    anteriores = {}

    while cola:
        coste_actual, nodo = heapq.heappop(cola)

        if nodo == destino:
            break

        for vecino, coste in grafo.get(nodo, []):
            nuevo_coste = coste_actual + coste
            if vecino not in distancias or nuevo_coste < distancias[vecino]:
                distancias[vecino] = nuevo_coste
                anteriores[vecino] = nodo
                heapq.heappush(cola, (nuevo_coste, vecino))

    if destino not in distancias:
        return None, None

    return distancias[destino], reconstruir_camino(anteriores, origen, destino)


def reconstruir_camino(anteriores, origen, destino):
    camino = [destino]
    while destino != origen:
        destino = anteriores[destino]
        camino.append(destino)
    camino.reverse()
    return camino


# ===============================
# PROGRAMA PRINCIPAL
# ===============================

inicializar_bd()

cargar_csv("mapa.csv")

grafo = crear_grafo()
aristas = obtener_aristas()

if not aristas:
    print("⚠️ No hay datos en la base de datos")
    print("Ejecuta cargar_csv('mapa.csv') una vez")
    exit()

for o, d, c in aristas:
    agregar_arista(grafo, o, d, c)

origen = input("Origen: ")
destino = input("Destino: ")

coste, camino = dijkstra(grafo, origen, destino)

if camino is None:
    print("❌ No existe ruta")
else:
    print("✅ Coste:", coste)
    print("🛣️ Ruta:", " -> ".join(camino))
    guardar_historico(origen, destino, coste, 0)
