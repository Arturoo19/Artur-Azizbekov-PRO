import { Component } from '@angular/core';
import { pedido } from '../../model/pedido';
import { Pedidos } from '../../services/pedidos';

@Component({
  selector: 'app-listar',
  standalone: false,
  templateUrl: './listar.html',
  styleUrl: './listar.css',
})
export class Listar {
  pedidos:pedido[] = []
  constructor(private pedidosServicio:Pedidos){
    this.pedidos = this.pedidosServicio.getPedidos()
  }
}
