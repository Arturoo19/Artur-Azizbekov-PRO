import { Component } from '@angular/core';
import { Tareas } from '../../services/tareas';
import { tarea } from '../../model/tarea';

@Component({
  selector: 'app-buscar',
  standalone: false,
  templateUrl: './buscar.html',
  styleUrl: './buscar.css',
})
export class Buscar {
  responsable:string = ""
  tareasFiltradas: tarea[] = [] 
  buscado:boolean = false

  constructor(private tareasServicio: Tareas){}

  buscarResponsable(){
    this.buscado = true
    if(this.responsable.trim() === ""){
      this.tareasFiltradas = []
      return
    }
    this.tareasFiltradas = this.tareasServicio.getTareaResponsable(this.responsable)
  }


}