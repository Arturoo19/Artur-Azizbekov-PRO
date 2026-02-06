import { Component } from '@angular/core';
import { tarea } from '../../model/tarea';
import { Tareas } from '../../services/tareas';

@Component({
  selector: 'app-listar',
  standalone: false,
  templateUrl: './listar.html',
  styleUrl: './listar.css',
})
export class Listar {
  tareas:tarea[] = []
  prioridadSeleccionada:number = 0
  
  constructor(private tareasServicio:Tareas){}

  ngOnInit(): void {
    this.tareas = this.tareasServicio.getTareas()
  }

  filtrarPorPrioridad(){
    if(this.prioridadSeleccionada === 0){
      this.tareas = this.tareasServicio.getTareas()
    } else{
      this.tareas = this.tareasServicio.getFiltrarTareas(this.prioridadSeleccionada)
    }
  }


}
