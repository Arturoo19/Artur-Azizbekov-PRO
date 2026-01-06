let botonAgregar = document.querySelector("#btnAgregar");
let botonLimpiar = document.querySelector("#btnLimpiar");
let inputNombre = document.querySelector("#inputNombre");
let inputApellido = document.querySelector("#inputApellido");
let inputFecha = document.querySelector("#inputFecha");
let listaAgregados = document.querySelector("#divAgregados ul");
let botonVaciar = document.querySelector("#btnVaciar");

botonAgregar.addEventListener("click", (ev) => {
  let nombre = inputNombre.value;
  let apellido = inputApellido.value;
  let fecha = inputFecha.value;

  let cosa = "";
  if (nombre.length == 0 || apellido.length == 0 || fecha.length == 0) {
    lanzarDialogo("Error", "Faltan datos", "warning");
  } else {
    agregarLi(nombre, apellido, fecha);
  }
});

botonLimpiar.addEventListener("click", (ev) => {
  limpiarCampos(inputNombre, inputApellido, inputFecha);
});

botonVaciar.addEventListener("click", (ev) => {
  listaAgregados.innerHTML = "";
});

function limpiarCampos() {
  for (let index = 0; index < arguments.length; index++) {
    arguments[index].value = "";
  }
}

function lanzarDialogo(title, text, icon) {
  Swal.fire({
    title: title,
    text: text,
    icon: icon,
  });
}
// 1. Seleccionamos el elemento select del HTML por su ID
let selectEdad = document.querySelector("#selectEdad");

// 2. Hacemos un bucle for sencillo que empiece en 18 y termine en 90
for (let i = 18; i <= 90; i++) {
  // 3. Creamos la etiqueta <option>
  let nodoOption = document.createElement("option");

  // 4. Le ponemos el valor y el texto (el número de la edad)
  nodoOption.value = i;
  nodoOption.innerText = i;

  // 5. Lo agregamos dentro del select
  selectEdad.appendChild(nodoOption);
}

function agregarLi(nombre, apellido, fecha) {
  let nodoLI = document.createElement("li");
  let nodoBoton = document.createElement("button");

  nodoBoton.classList.add("btn", "btn-danger");
  nodoBoton.innerText = "Borrar";
  nodoBoton.addEventListener("click", (e) => {
    nodoLI.classList.remove("animate__fadeInRight");
    nodoLI.classList.add("animate__backOutLeft");

    nodoLI.addEventListener("animationend", () => {
      nodoLI.remove();
    });
  });

  nodoLI.innerText = `${nombre} ${apellido} ${fecha}`;

  nodoLI.classList.add(
    "animate__animated",
    "animate__fadeInRight",
    "list-group-item",
    "d-flex",
    "justify-content-between",
    "align-items-start"
  );

  nodoLI.appendChild(nodoBoton);

  listaAgregados.appendChild(nodoLI);
  limpiarCampos(inputNombre, inputApellido, inputFecha);
}
