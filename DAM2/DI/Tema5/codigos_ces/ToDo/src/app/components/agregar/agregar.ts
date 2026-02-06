
import { Component } from '@angular/core';
import { tarea } from '../../model/tarea';
import { Tareas } from '../../services/tareas';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-agregar',
  standalone: false,
  templateUrl: './agregar.html',
  styleUrl: './agregar.css',
})
export class Agregar {
  items: string[] = [];
  nombre?: string;
  fecha?: string;
  responsable?: string;
  prioridad?: string;
  descripcion?: string;
  item?: string;
  tareas: tarea[] = [];

  constructor(private tareasServicio: Tareas) {
    // logica
  }

  agregarItem() {
    if (this.item != undefined) {
      this.items.push(this.item);
    } else {
      // saltar un aviso
    }
  }

  agregarTarea() {
    /* if(){

    } else {

    } */
    let tarea: tarea = {
      nombre: this.nombre,
      responsable: this.responsable,
      items: this.items,
      fecha: this.fecha,
      prioridad: Number(this.prioridad),
      descipcion: this.descripcion,
    };

    const nuevaTarea = this.tareasServicio.agregarTarea(tarea)

    if(!nuevaTarea){
      Swal.fire({
        title: "Error",
        text: "Responsable ya existe",
        icon: "error"
      });
    } else{
      Swal.fire({
        title: "Good",
        text: "Tarea agregada correctamente",
        icon: "success"
      });

    }
    this.limpiarFormulario()

    // llamar al metodo agregarTarea del servicio
    
  }
  limpiarFormulario(){
    this.nombre = ""
    this.responsable = ""
    this.items = []
    this.fecha = ""
    this.prioridad = ""
    this.descripcion = ""
  }
}
