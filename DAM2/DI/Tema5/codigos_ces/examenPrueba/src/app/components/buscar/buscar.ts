import { Component } from '@angular/core';
import { pedido } from '../../model/pedido';
import { ActivatedRoute, Router } from '@angular/router';
import { Pedidos } from '../../services/pedidos';

@Component({
  selector: 'app-buscar',
  standalone: false,
  templateUrl: './buscar.html',
  styleUrl: './buscar.css',
})
export class Buscar {
  nombreBuscar?:string
  pedidos:pedido[] = []
  filtradas:pedido[] = []

  constructor(
    private route: ActivatedRoute,
    private pedidosServicio: Pedidos
  ){
    this.route.paramMap.subscribe(params=>{
      this.nombreBuscar = params.get('nombre')?? undefined

      if(this.nombreBuscar){
        this.filtradas = this.pedidosServicio.getPedidos()
        .filter(p=> p.nombreCliente?.toLowerCase() === this.nombreBuscar?.toLowerCase())
      }
    })
  }
}
