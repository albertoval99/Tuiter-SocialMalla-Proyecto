document.addEventListener("DOMContentLoaded",listeners);
function listeners(){
    cargarTemaPorDefecto();
    document.querySelector('#btn-tema').addEventListener("click",tema);
    //Este es el boton del tema para el movil
    document.querySelector('.btn-tema').addEventListener("click",tema);
    darLike();
    document.querySelector('#nombre').addEventListener("blur",validarNombre);
    document.querySelector('#apellidos').addEventListener("blur",validarApellidos);
    document.querySelector('#diaNacimiento').addEventListener("blur",validarEdad);
    document.querySelector('#nombreUsuario').addEventListener("blur",validarNombreUsuario);
    document.querySelector('#password').addEventListener("blur",validarPassword);
    document.querySelector('#repeatPassword').addEventListener("blur",validarRepeatPassword);
    document.querySelector('#email').addEventListener("blur",validarEmail);
    document.querySelector('#numeroTelefono').addEventListener("blur",validarNumeroTelefono);

}
/*Cambiar tema*/
function cargarTemaPorDefecto(){
    const temaActual = localStorage.getItem('tema');
    if (temaActual === 'dark') {
        aplicarTemaOscuro();
    } else {
        aplicarTemaClaro();
    }
}
function tema(){
    const temaActual = localStorage.getItem('tema');

    if (temaActual === 'dark') {
        aplicarTemaClaro();
    } else {
        aplicarTemaOscuro();
    }
}
function aplicarTemaOscuro() {
    const indexCss = document.querySelector('#styles');
    const newSocialCss = document.querySelector('#newSocialStyles');
    indexCss.href = 'css/stylesDark.css';
    if (newSocialCss) {
        newSocialCss.href = 'css/stylesNewSocialDark.css';
    }
    localStorage.setItem('tema', 'dark');
}
function aplicarTemaClaro() {
    const indexCss = document.querySelector('#styles');
    const newSocialCss = document.querySelector('#newSocialStyles');
    indexCss.href = 'css/styles.css';
    if (newSocialCss) {
        newSocialCss.href = 'css/stylesNewSocial.css';
    }
    localStorage.setItem('tema', 'light');
}
/*Poder dar Like*/
function darLike(){
     const botonesLike = document.querySelectorAll('.boton-like');
     /*Sin recorrerlos solo actua con el primero*/
       botonesLike.forEach(b => {
         b.addEventListener("click", () => {
            b.classList.toggle('likePulsado');
            /**Con el toggle cambio una clase por otra*/
          });
        });

}
/*Validaciones*/
function validarNombre(){
    let inputNombre= document.querySelector('#nombre');
    let error = document.querySelector('#errorNombre');
    if(inputNombre.value.length < 3){
        error.innerText = "El nombre debe tener como minimo 3 caracteres";
        inputNombre.classList.add("invalido");
        return false;
    }
     inputNombre.value = inputNombre.value.charAt(0).toUpperCase() + inputNombre.value.substring(1).toLowerCase();
     error.innerText = "";
     inputNombre.classList.remove("invalido");
     return true;
}
function validarApellidos(){
     let inputApellidos= document.querySelector('#apellidos');
     let error= document.querySelector('#errorApellidos');
     if(inputApellidos.value.length < 5){
         error.innerText = "Los apellidos deben tener como minimo 5 caracteres";
         inputApellidos.classList.add("invalido");
         return false;
     }
//     inputApellidos.value= inputApellidos.value.charAt(0).toUpperCase() + inputApellidos.value.substring(1).toLowerCase();
     let apellidos = inputApellidos.value.split(" ");//LO METO EN UN ARRAY
     let apellidosFormateados = apellidos.map((apellido)=>apellido.charAt(0).toUpperCase() + apellido.substring(1).toLowerCase());//LO FORMATEO
     inputApellidos.value = apellidosFormateados.join(" ");
     error.innerText="";
     inputApellidos.classList.remove("invalido");
     return true;
}
function validarEdad(){
    let inputEdad= document.querySelector('#diaNacimiento');
    let error= document.querySelector('#errorEdad');
    let fechaInput= new Date(inputEdad.value);
    let fecha18Anyos= new Date(Date.now()- 18 * 365 * 24 * 60 * 60 * 1000);
    if(fechaInput>fecha18Anyos){
        error.innerText = "Debes tener al menos 18 años.";
        inputEdad.classList.add("invalido");
        return false;
    }
    error.innerText = "";
    inputEdad.classList.remove("invalido");
    return true;
}
function validarNombreUsuario(){
    let inputNombreUsuario= document.querySelector('#nombreUsuario');
    let error= document.querySelector('#errorNombreUsuario');
    if (inputNombreUsuario.value.length<5){
        error.innerText="El nombre de usuario debe tener como minimo 5 caracteres";
        inputNombreUsuario.classList.add("invalido");
        return false;
    }
    error.innerText="";
    inputNombreUsuario.classList.remove("invalido");
    return true;
}
function validarPassword(){
    let inputPassword= document.querySelector('#password');
    let error = document.querySelector('#errorPassword');
    let expresion = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/;

    if (!expresion.test(inputPassword.value)) {
        error.textContent = "La contraseña debe tener al menos 8 caracteres, incluyendo una mayúscula, una minúscula y un número.";
        inputNombre.classList.add("invalido");
        return false;
    }
    error.textContent="";
    inputNombre.classList.remove("invalido");
    return true;

}
function validarRepeatPassword(){
    let inputPassword= document.querySelector('#password');
    let inputRepeatPassword= document.querySelector('#repeatPassword');
    let error = document.querySelector('#errorRepeatPassword');
    if (inputPassword.value !== inputRepeatPassword.value) {
        error.textContent = "Las contraseñas no coinciden";
        inputNombre.classList.add("invalido");
        return false;
    }
    error.textContent="";
    inputNombre.classList.remove("invalido");
    return true;
}
function validarEmail(){
    let inputEmail = document.querySelector('#email');
    let error= document.querySelector('#errorEmail');
    let expresion = /^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/g;
    if (!expresion.test(inputEmail.value)) {
        error.textContent = "El correo electrónico no es válido";
        inputNombre.classList.add("invalido");
        return false;
    }
    error.textContent="";
    inputNombre.classList.remove("invalido");
    return true;
}
function validarNumeroTelefono(){}