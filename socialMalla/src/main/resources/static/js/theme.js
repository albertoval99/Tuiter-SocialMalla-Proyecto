
const indexCss = document.querySelector('#styles');
const newSocialCss = document.querySelector('#newSocialStyles');
const botonTema = document.querySelector('#btn-tema');

const temaActual = localStorage.getItem('tema');


if (temaActual === 'dark') {
    aplicarTemaOscuro();
} else {
    aplicarTemaClaro();
}


function aplicarTemaOscuro() {
    indexCss.href = 'css/stylesDark.css';

    if (newSocialCss) {
        newSocialCss.href = 'css/stylesNewSocialDark.css';
    }

    localStorage.setItem('tema', 'dark');
    botonTema.textContent = 'LIGHT MODE';
}


function aplicarTemaClaro() {
    indexCss.href = 'css/styles.css';

    if (newSocialCss) {
        newSocialCss.href = 'css/stylesNewSocial.css';
    }

    localStorage.setItem('tema', 'light');
    botonTema.textContent = 'DARK MODE';
}


botonTema.addEventListener('click', () => {
    if (localStorage.getItem('tema') === 'dark') {
        aplicarTemaClaro();
    } else {
        aplicarTemaOscuro();
    }
});
