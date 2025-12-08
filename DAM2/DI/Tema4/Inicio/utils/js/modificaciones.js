let botonAgregar = document.querySelector("#btnAgregar");
let botonLimpiar = document.querySelector("#btnLimpiar");

botonAgregar.addEventListener("click", (ev) => {
  console.log("Boton pulsado");
  console.log(ev);

  let nombre = document.querySelector("#inputNombre").value.trim();
  let apellido = document.querySelector("#inputApellido").value.trim();
  let fecha = document.querySelector("#inputFecha").value.trim();

  if (nombre === "" || apellido === "" || fecha === "") {
    console.log("Faltan datos");
    alert("Faltan datos");
  } else {
    console.log(nombre, apellido, fecha);
  }
});

botonLimpiar.addEventListener("click", (ev) => {
  limpiarCampos;
});

function limpiarCampos() {
  for (let index = 0; index < arguments.length; index++) {
    arguments[index].value = "";
  }
}

function lanzarDialogo(title, text, icon) {
  Swal.fire({
    title: "Good job!",
    text: "You clicked the button!",
    icon: "success",
  });
}
