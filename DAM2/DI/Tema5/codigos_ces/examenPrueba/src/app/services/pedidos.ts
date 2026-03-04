import { Injectable } from '@angular/core';
import { pizza } from '../model/pizza';
import { pedido } from '../model/pedido';

@Injectable({
  providedIn: 'root',
})
export class Pedidos {
  contador = 1
  pizzas:pizza[] = [
    {
      id:1,
      nombre:'barbacoa',
      precio:14
    },
    {
      id:2,
      nombre:'hawaiana',
      precio:15
    },
    {
      id:3,
      nombre:'jamon y queso',
      precio:12
    }
  ]
  pedidos:pedido[] = []

  agregarPedido(pedido:pedido){
    pedido.id = this.contador
    this.pedidos.push(pedido)
    this.contador++
    
  }
  getPedidos(): pedido[]{
    return this.pedidos
  }
  getPedidoPorID(param:number): pedido{
    return this.pedidos.find((item)=> item.id == param) as pedido
  }
  getPizzas():pizza[]{
    return this.pizzas
  }

  
}
