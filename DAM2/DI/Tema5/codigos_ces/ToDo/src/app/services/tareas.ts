
import { Injectable } from '@angular/core';
import { tarea } from '../model/tarea';
import { find } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Tareas {
  tareas: tarea[] = [];

  // agregar una tarea
  agregarTarea(tarea: tarea): boolean {
    if (this.existeResponsable(tarea)) {
      return false; 
    }

    this.tareas.push(tarea);
    return true; 
    }


  existeResponsable(nuevaTarea:tarea): boolean{

    const existe = this.tareas.find(
      it => it.responsable === nuevaTarea.responsable
    )
    if(existe){
      return true
    }

    return false
  }

  // obtener todas las tareas
  getTareas(): tarea[] {
    return this.tareas;
  }

  getFiltrarTareas(opcion:number){
    return this.tareas.filter(it => it.prioridad == opcion)
  }

  // obtener todas las tareas por prioridad
  getTareasFiltradas() {
    return {
      alta: this.tareas.filter(it => it.prioridad ==1),
      media: this.tareas.filter(it => it.prioridad ==2),
      baja: this.tareas.filter(it => it.prioridad == 3)
    }

  }
  getTareaResponsable(responsable:string){
    return this.tareas.filter(
      t => t.responsable?.toLowerCase() === responsable.toLowerCase()
    )
  }
}
