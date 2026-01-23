
import { Component } from '@angular/core';

@Component({
  selector: 'app-decisiones',
  standalone: false,
  templateUrl: './decisiones.html',
  styleUrl: './decisiones.css',
})
export class Decisiones {
  nombre: string = '';
  apellido: string = '';
  edad: number = 0;
  salario: number = 0;
  experiencia: number = 0;
  resultado: { mensaje: string; esIdoneo: boolean } | null = null;
  esIdoneo = false

  mostrar: boolean = true;

  cambiarMostar() {
    this.mostrar = !this.mostrar;
  }
  evaluarCandidato(){
    const nombreCompleto = `${this.nombre} ${this.apellido}`

    
    if(this.edad>18 && this.experiencia>2 && this.salario < 20000){
      this.esIdoneo =true
    }
     else if (this.edad > 18 && this.salario < 50000 && this.experiencia > 3) {
      this.esIdoneo = true;
    }
    
    else if (this.experiencia > 10 && this.edad > 18) {
      this.esIdoneo = true;
    }
    if (this.esIdoneo) {
      this.resultado = {
        mensaje: `El candidato con nombre ${nombreCompleto} se ha contratado`,
        esIdoneo: true
      };
    } else {
      this.resultado = {
        mensaje: `El candidato con nombre ${nombreCompleto} no cumple los requisitos`,
        esIdoneo: false
      };
    }
  }
  reseteardatos(){
    this.nombre = ""
    this.apellido = ""
    this.edad = 0
    this.experiencia = 0
    this.esIdoneo = false
    this.salario = 0
  }

}
