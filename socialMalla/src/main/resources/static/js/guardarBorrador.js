document.addEventListener("DOMContentLoaded", () => {

    let botonSaveBorrador = document.querySelector("#saveBorrador");
    let tituloInput = document.querySelector("#titulo");
    let descripcionInput = document.querySelector("#descripcion");

    botonSaveBorrador.addEventListener("click", (e) => {
        e.preventDefault();
        let titulo = tituloInput.value;
        let descripcion = descripcionInput.value;

        let borrador = {titulo: titulo,descripcion: descripcion,fecha: new Date()};
        const borradores = JSON.parse(localStorage.getItem("borradores")) || [];
        borradores.push(borrador);

        localStorage.setItem("borradores", JSON.stringify(borradores));

        // Para limpiar el formulario cuando se envia
        tituloInput.value = "";
        descripcionInput.value = "";
        alert("BORRADOR GUARDADO CON EXITO");
    });
});