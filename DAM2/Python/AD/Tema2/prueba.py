def calcular_cheques(n,valores=[50,20,10,5,1],i=0):
    if n == 0:
        return 0
    
    valor = valores[i]
    if(n>=valor):
        print(f"1 cheque de {valor} queda {n-valor}")
        return calcular_cheques(n-valor,valores,i)
    else:
        return calcular_cheques(n,valores,i+1)


def inorden(arbol,nodo):
    if nodo is None:
        return
    
    izquierda,derecha = arbol[nodo]
    inorden(arbol,izquierda)
    print(nodo)
    inorden(arbol,derecha)