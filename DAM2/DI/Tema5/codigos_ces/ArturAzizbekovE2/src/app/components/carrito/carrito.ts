import { Component } from '@angular/core';
import Swal from 'sweetalert2';
import { Libro } from '../../model/libro';
import { CarritoServicio } from '../../service/carrito-servicio';
import { BrowserModule } from "@angular/platform-browser";
import { LibroCard } from "../libro-card/libro-card";

@Component({
  selector: 'app-carrito',
  templateUrl: './carrito.html',
  imports: [BrowserModule, LibroCard]
})
export class Carrito {

  carrito: Libro[] = [];

  constructor(private carritoService: CarritoServicio) {
    this.carrito = this.carritoService.getCarrito();
  }

  comprar() {
    Swal.fire({
      title: 'Compra correcta',
      icon: 'success'
    });
    this.carritoService.vaciar();
    this.carrito = [];
  }
}
