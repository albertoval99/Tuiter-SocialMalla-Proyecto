document.addEventListener("DOMContentLoaded",listeners);
function listeners(){
    cargarTemaPorDefecto();
    document.querySelector('#btn-tema').addEventListener("click",tema);
    //Este es el boton para el movil
    document.querySelector('.btn-tema').addEventListener("click",tema);

}
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