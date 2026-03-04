import { Component,Input } from '@angular/core';
import { pedido } from '../../model/pedido';
import { Router } from '@angular/router';

@Component({
  selector: 'app-carta',
  standalone: false,
  templateUrl: './carta.html',
  styleUrls: ['./carta.css'],
})
export class Carta {
  @Input() item!:pedido

  constructor(private router:Router){}

  irADetalle(){
    this.router.navigate(['/detalle',this.item.id])
  }
}
