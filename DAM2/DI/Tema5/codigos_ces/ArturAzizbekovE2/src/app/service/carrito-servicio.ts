import { Injectable } from '@angular/core';
import { Libro } from '../model/libro';

@Injectable({
  providedIn: 'root',
})
export class CarritoServicio {
  private carrito: Libro[] = [];

  getCarrito(): Libro[] {
    return this.carrito;
  }

  agregar(libro: Libro) {
    this.carrito.push(libro);
  }

  vaciar() {
    this.carrito = [];
  }
}
