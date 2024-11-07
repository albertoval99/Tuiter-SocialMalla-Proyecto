CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    nombreUsuario VARCHAR(30) NOT NULL UNIQUE,
    diaNacimiento DATE NOT NULL,
    password VARCHAR(100) NOT NULL,
    numeroTelefono VARCHAR(15) NOT NULL
);

CREATE TABLE posts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    descripcion VARCHAR(200) NOT NULL,
    fechaPublicacion VARCHAR(50) NOT NULL,
    numeroLikes INT NOT NULL,
    nombreUsuario VARCHAR(50) NOT NULL
);