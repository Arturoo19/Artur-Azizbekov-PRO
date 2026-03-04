import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Libro } from '../../model/libro';
import { CarritoServicio } from '../../service/carrito-servicio';
import { BrowserModule } from "@angular/platform-browser";

@Component({
  selector: 'app-libro-card',
  templateUrl: './libro-card.html',
  imports: [BrowserModule]
})
export class LibroCard {

  @Input() libro!: Libro;

  constructor(
    private router: Router,
    private carritoService: CarritoServicio
  ) {}

  verDetalles() {
    this.router.navigate(['/detalles', this.libro.id]);
  }

  agregarCarrito() {
    this.carritoService.agregar(this.libro);
  }
}
