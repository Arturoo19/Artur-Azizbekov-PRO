import { Component } from '@angular/core';
import { Pedidos } from '../../services/pedidos';
import { pedido } from '../../model/pedido';
import { pizza } from '../../model/pizza';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-agregar',
  standalone: false,
  templateUrl: './agregar.html',
  styleUrl: './agregar.css',
})
export class Agregar {
  nombre?: string;
  telefono?: number;
  tamanio?: 'S'|'M'|'L';
  pizzaSeleccionada?: number;
  pizzas:pizza[] = []


  constructor(private pedidosServicio:Pedidos){
    this.pizzas = this.pedidosServicio.getPizzas()
  }


  agregarPedido(){
    if (!this.nombre || !this.telefono || !this.tamanio || !this.pizzaSeleccionada) {
      Swal.fire({
        title: 'Error',
        text: 'Completa todos los campos',
        icon: 'error'
      });
      return;
    }

    const pizzaElegida = this.pizzas.find(p=>p.id == this.pizzaSeleccionada)
    if(!pizzaElegida) return

    let nuevoPedido:pedido = {
      id:-1,
      nombreCliente:this.nombre,
      telefono:this.telefono,
      tamano:this.tamanio,
      pizza:pizzaElegida,
      precioFinal:pizzaElegida.precio
    }
    this.pedidosServicio.agregarPedido(nuevoPedido)

    this.nombre = ''
    this.telefono = undefined
    this.tamanio = undefined
    this.pizzaSeleccionada = undefined
  }


}
