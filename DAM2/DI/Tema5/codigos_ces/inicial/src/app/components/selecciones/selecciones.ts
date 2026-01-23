import { Component } from '@angular/core';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-selecciones',
  standalone: false,
  templateUrl: './selecciones.html',
  styleUrl: './selecciones.css',
})
export class Selecciones {
  seleccion = "1"
  nombre: string = '';
  tipoPago:string ="";
  coste : number = 0
  dirFacturacion:string = ""
  dirEnvio:string = "" 

  telefono:number = 0
  cuenta:string = ""
  numeroTarjeta:number = 0
  fechaCaducidad:string = "" 
  cvv:number = 0

  validarCompra() {
    let costeFinal = this.coste
    let datosPago = ""
    let tipoTexto = ""

    if(this.tipoPago==="1"){
      tipoTexto = "Bizum"
      datosPago = `Telefono: ${this.telefono}`
    }
    if(this.tipoPago ==="2"){
      tipoTexto = "Transferencia"
      datosPago = `Cuenta: ${this.cuenta}`
      costeFinal = this.coste * 1.05
    }
    if(this.tipoPago ==="3"){
      tipoTexto = "tarjeta"
      datosPago = `Numero de tarjeta: ${this.numeroTarjeta}, Fecha: ${this.fechaCaducidad}, CVV: ${this.cvv}`
    }

    Swal.fire({
      title: "Compra realizada correctamente",
      icon: "success",
      html: `
      <p><b>El producto se envía correctamente al usuario:</b> ${this.nombre}</p>
        <p><b>Coste:</b> ${costeFinal.toFixed(2)} €</p>
        <p><b>Dirección de facturación:</b> ${this.dirFacturacion}</p>
        <hr>
        <p><b>Tipo de pago:</b> ${tipoTexto}</p>
        <p>${datosPago}</p>
      `,
      confirmButtonText:"Aceptar"
    });
  }
}
