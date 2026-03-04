import { Component } from '@angular/core';
import { pedido } from '../../model/pedido';
import { ActivatedRoute } from '@angular/router';
import { Pedidos } from '../../services/pedidos';

@Component({
  selector: 'app-detail',
  standalone: false,
  templateUrl: './detail.html',
  styleUrl: './detail.css',
})
export class Detail {
  pedido?:pedido

  constructor(
    private gestorRutas:ActivatedRoute,
    private pedidosServicio:Pedidos
  ){
    let dato:string = this.gestorRutas.snapshot.params['id']
    this.pedido = this.pedidosServicio.getPedidoPorID(Number(dato))
  }

}
