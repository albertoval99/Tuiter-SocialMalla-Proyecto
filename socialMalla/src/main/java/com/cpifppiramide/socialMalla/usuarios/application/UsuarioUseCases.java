package com.cpifppiramide.socialMalla.usuarios.application;

import com.cpifppiramide.socialMalla.usuarios.domain.Usuario;
import com.cpifppiramide.socialMalla.usuarios.domain.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.Optional;

public class UsuarioUseCases {

    private UsuarioRepository usuarioRepository;
    private BCryptPasswordEncoder passwordEncoder;


    public UsuarioUseCases(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();

    }

    public void registro(String nombre, String apellidos, String nombreUsuario, LocalDate diaNacimiento, String password, String numeroTelefono) {
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellidos(apellidos);
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setDiaNacimiento(diaNacimiento);
        usuario.setPassword(password);
        usuario.setNumeroTelefono(numeroTelefono);

        String cifrada = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(cifrada);

        this.usuarioRepository.saveUsuario(usuario);
    }

    public Usuario iniciarSesion(String nombreUsuario, String password) {

        Optional<Usuario> usuario = usuarioRepository.buscarPorNombreUsuario(nombreUsuario);

        if (passwordEncoder.matches(password, usuario.get().getPassword())) {
            return usuario.get();
        } else {
            throw new IllegalArgumentException("Contraseña incorrecta");
        }
    }
}
