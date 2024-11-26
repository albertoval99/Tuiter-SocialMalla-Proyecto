document.addEventListener("DOMContentLoaded", () => {

    const borradores = JSON.parse(localStorage.getItem("borradores")) || [];

    borradores.forEach((b) => {
        let postContainer = document.createElement("div");
        postContainer.className = "post-container";

        let post = document.createElement("div");
        post.className = "post";

        let titulo = document.createElement("div");
        titulo.className = "post-titulo";
        titulo.textContent = b.titulo;

        let descripcion = document.createElement("div");
        descripcion.className = "post-descripcion";
        descripcion.textContent = b.descripcion;

        let footer = document.createElement("div");
        footer.className = "post-footer";

        let usuario = document.createElement("span");
        usuario.className = "post-usuario";
        usuario.textContent = "alberto";

        let fecha = document.createElement("span");
        fecha.className = "post-fecha";
        let fechaFormatear= new Date(b.fecha);
        let year = fechaFormatear.getFullYear();
        let month = fechaFormatear.getMonth();
        let day = fechaFormatear.getDate();
        let formateada= `${year}-${month}-${day}`;
        fecha.textContent = formateada;

        footer.appendChild(usuario);
        footer.appendChild(fecha);

        post.appendChild(titulo);
        post.appendChild(descripcion);
        post.appendChild(footer);

        postContainer.appendChild(post);

        let containerBorradores = document.querySelector("#borradores");
        containerBorradores.appendChild(postContainer);
    });
});
