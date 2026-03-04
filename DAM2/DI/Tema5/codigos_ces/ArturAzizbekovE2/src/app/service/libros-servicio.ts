import { Injectable } from '@angular/core';
import { Libro } from '../model/libro';
import librosData from '../../assets/libros.json';

@Injectable({
  providedIn: 'root',
})
export class LibrosServicio {
  private libros: Libro[] = librosData;

  getLibros(): Libro[] {
    return this.libros;
  }
  getLibrosById(param:Number):Libro{
    return this.libros.find((item)=>item.id == param) as Libro
  } 

//   getLibroById(id: number): Libro | undefined {
// this.libros.find(l => [l.id](http://l.id/) === id);
}

