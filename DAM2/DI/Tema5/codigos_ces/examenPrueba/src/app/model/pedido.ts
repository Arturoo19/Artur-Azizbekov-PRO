import { pizza } from "./pizza";

export interface pedido{
    id:number,
    nombreCliente?:string,
    telefono?: number,
    tamano: 'S' | 'M' | 'L';
    pizza:pizza,
    precioFinal:number
}