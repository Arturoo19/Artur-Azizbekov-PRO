function realizarCalculo(op1, op2) {
  console.log(`la suma de los parametros es ${op1 + op2}`);
}

realizarCalculo(3, 6);

function realizarCalculoFantasma(op1) {
  let listaArgumentos = [];
  let suma = 0;
  arguments.array.forEach(element, indexedDB, (data) => {
    suma += element;
  });
  console.log("Caclulo fantasma");
  console.log(op1 + " es parametro reqerido");

  console.log(`El numero de argumentos famtasma es de ${arguments.length}`);
}
alert(realizarCalculoFantasma(1, 2, 3, 4));
