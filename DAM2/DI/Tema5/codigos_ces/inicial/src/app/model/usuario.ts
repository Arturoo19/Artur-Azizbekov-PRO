export class usuario {
  // attri
  // const
  hobbies: string[];
  constructor(
    private nombre: string,
    private apellido: string,
    private edad: number,
  ) {
    this.hobbies = [];
  }
  // metodos -> para poder agregar un hobbie
  agregarHobbie(item: string) {
    this.hobbies.push(item);
  }

  getNombre(): string {
    return this.nombre;
  }
   getApellido() {
    return this.apellido;
  }

  getEdad() {
    return this.edad;
  }
  setNombre(nombre:string){
    this.nombre = nombre
  }
  setApellido(apellido:string){
    this.apellido = apellido
  }
  setEdad(edad:number){
    this.edad = edad
  }
}