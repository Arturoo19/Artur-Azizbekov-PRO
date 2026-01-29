import { Component } from '@angular/core';
import { tarea } from '../../model/tarea';

@Component({
  selector: 'app-listar',
  standalone: false,
  templateUrl: './listar.html',
  styleUrl: './listar.css',
})
export class Listar {
  tareas:tarea[] = []
  

}
