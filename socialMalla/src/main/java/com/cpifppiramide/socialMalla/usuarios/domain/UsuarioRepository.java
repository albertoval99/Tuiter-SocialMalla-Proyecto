package com.cpifppiramide.socialMalla.usuarios.domain;

import java.util.Optional;

public interface UsuarioRepository {
    void saveUsuario(Usuario usuario);
    Optional<Usuario> buscarPorNombreUsuario(String nombreUsuario);
   

}
