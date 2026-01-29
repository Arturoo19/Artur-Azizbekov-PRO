#1
def factorial(n):
    if n == 0 or n == 1:  
        return 1
    else:                
        return n * factorial(n - 1)

#2
def multiplicar(a, b):
    if a == 0 or b == 0:  
        return 0
    else:                
        return a + multiplicar(a, b - 1)

#4
def potencia(n, m):
    if n == 0 and m == 0:
        return "Indeterminación"
    if m == 0:
        return 1
    else:
        return n * potencia(n, m - 1)
#5
def resta(a, b):
    if b == 0:        
        return a
    else:             
        return resta(a - 1, b - 1)
