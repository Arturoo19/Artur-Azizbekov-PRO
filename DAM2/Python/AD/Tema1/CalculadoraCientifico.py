import math
import colorama

clave = "1234"


def pedir_numero(mensaje):
    return float(input(mensaje))


def sumar(a, b):
    return a + b

def restar(a, b):
    return a - b

def multiplicar(a, b):
    return a * b

def dividir(a, b):
    return a / b

def valor_absoluto(a):
    return abs(a)

def seno(a):
    return math.sin(a)

def coseno(a):
    return math.cos(a)

def tangente(a):
    return math.tan(a)

def log10(a):
    if a <= 0:
        print("no valido para log10")
        return None
    return math.log10(a)

def loge(a):
    if a <= 0:
        print("no valido para loge")
        return None
    return math.log(a)

def exponente(a):
    return math.exp(a)

def raiz(a):
    if a < 0:
        print("no valido para raiz")
        return None
    return math.sqrt(a)

print("calculadora cientifica")
contraseña = input("escribe clave: ")

if contraseña != clave:
    print("clave incorrecta")
else:
    while True:
        print("\nmenu:")
        print("1. sumar")
        print("2. restar")
        print("3. multiplicar")
        print("4. dividir")
        print("5. valor absoluto")
        print("6. seno")
        print("7. coseno")
        print("8. tangente")
        print("9. log base 10")
        print("10. log neperiano")
        print("11. e elevado a x")
        print("12. raiz cuadrada")
        print("13. cambiar clave")
        print("14. apagar")

        opcion = input("elige opcion: ")

        if opcion == "1":
            a = pedir_numero("primer numero: ")
            b = pedir_numero("segundo numero: ")
            print("resultado:", sumar(a, b))

        elif opcion == "2":
            a = pedir_numero("primer numero: ")
            b = pedir_numero("segundo numero: ")
            print("resultado:", restar(a, b))

        elif opcion == "3":
            a = pedir_numero("primer numero: ")
            b = pedir_numero("segundo numero: ")
            print("resultado:", multiplicar(a, b))

        elif opcion == "4":
            a = pedir_numero("primer numero: ")
            b = pedir_numero("segundo numero: ")
            r = dividir(a, b)
            print("resultado:", r)

        elif opcion == "5":
            a = pedir_numero("numero: ")
            print("resultado:", valor_absoluto(a))

        elif opcion == "6":
            a = pedir_numero("numero en radianes: ")
            print("resultado:", seno(a))

        elif opcion == "7":
            a = pedir_numero("numero en radianes: ")
            print("resultado:", coseno(a))

        elif opcion == "8":
            a = pedir_numero("numero en radianes: ")
            print("resultado:", tangente(a))

        elif opcion == "9":
            a = pedir_numero("numero: ")
            r = log10(a)
        
            print("resultado:", r)

        elif opcion == "10":
            a = pedir_numero("numero: ")
            r = loge(a)    
            print("resultado:", r)

        elif opcion == "11":
            a = pedir_numero("numero: ")
            print("resultado:", exponente(a))

        elif opcion == "12":
            a = pedir_numero("numero: ")
            r = raiz(a)
            print("resultado:", r)

        elif opcion == "13":
            nueva = input("nueva clave: ")
            clave = nueva
            print("clave cambiada")

        elif opcion == "14":
            print("apagando...")
            break

        else:
            print("opcion no valida")



    