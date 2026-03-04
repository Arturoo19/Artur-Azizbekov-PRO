import { Component, signal } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  standalone: false,
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('examenPrueba');
  opcion:string = '1'
  constructor(private gestorRutas: Router){}

  navegarPorParam(param:string){
    this.gestorRutas.navigate(['/buscar',param])
  }
}
