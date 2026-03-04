import { Component } from '@angular/core';
import { Libro } from '../../model/libro';
import { LibrosServicio } from '../../service/libros-servicio';
import { BrowserModule } from "@angular/platform-browser";
import { LibroCard } from "../libro-card/libro-card";

@Component({
  selector: 'app-libros',
  templateUrl: './libros.html',
  imports: [BrowserModule, LibroCard]
})
export class Libros {

  libros: Libro[] = [];

  constructor(private librosService: LibrosServicio) {
    this.libros = this.librosService.getLibros();
  }
}
