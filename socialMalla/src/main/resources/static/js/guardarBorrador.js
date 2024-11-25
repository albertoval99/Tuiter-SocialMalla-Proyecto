document.addEventListener("DOMContentLoaded", () => {

    const botonSaveBorrador = document.getElementById("saveBorrador");
    const tituloInput = document.getElementById("titulo");
    const descripcionInput = document.getElementById("descripcion");

    botonSaveBorrador.addEventListener("click", (e) => {
        e.preventDefault();
        const titulo = tituloInput.value;
        const descripcion = descripcionInput.value;


        const borrador = {titulo: titulo,descripcion: descripcion,fecha: new Date()};
        const borradores = JSON.parse(localStorage.getItem("borradores")) || [];
        borradores.push(borrador);

        localStorage.setItem("borradores", JSON.stringify(borradores));

        // Para limpiar el formulario
        tituloInput.value = "";
        descripcionInput.value = "";

        alert("Borrador guardado");
    });
});