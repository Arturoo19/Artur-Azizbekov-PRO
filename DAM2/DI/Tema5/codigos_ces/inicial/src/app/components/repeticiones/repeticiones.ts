import Swal from 'sweetalert2';
import { Component } from '@angular/core';
import { usuario } from '../../model/usuario';

@Component({
  selector: 'app-repeticiones',
  standalone:false,
  templateUrl: './repeticiones.html',
  styleUrl: './repeticiones.css'
})
export class Repeticiones {

  usuarios: usuario[] = [];

  nombre: string = '';
  apellido: string = '';
  edad: number | null = null;
  hobbie: string = '';
  usuario:usuario = new usuario("","",0)

  hobbiesTemp: string[] = [];

  agregarHobbie() {
    if(this.hobbie.length>0){

    }
  }

  agregarUsuario() {
    this.usuario.setNombre(this.nombre)
    this.usuario.setApellido(this.apellido)
    this.usuario.setEdad(Number(this.edad))

  }

  lanzarCuadro(titulo: string, texto: string, icono: any) {
    Swal.fire({
      title: titulo,
      text: texto,
      icon: icono
    });
  }
}
