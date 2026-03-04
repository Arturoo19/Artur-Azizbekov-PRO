import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Libro } from '../../model/libro';
import { LibrosServicio } from '../../service/libros-servicio';
import { BrowserModule } from "@angular/platform-browser";

@Component({
  selector: 'app-detalles',
  templateUrl: './detalles.html',
  imports: [BrowserModule]
})
export class Detalles {

  libro?: Libro;

  constructor(
    private route: ActivatedRoute,
    private librosService: LibrosServicio
  ) {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.libro = this.librosService.getLibrosById(id);
  }
}
