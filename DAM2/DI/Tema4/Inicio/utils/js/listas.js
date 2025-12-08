let lista = ["hola", "adios", "Programacion"];

lista.push("Palabra nueva", "Nueva 2");

lista[2] = "Palabra mia";
lista.pop();
lista.shift();

lista = ista.filter((element) => {
  return element != "Palabra mia";
});

console.log(lista);
