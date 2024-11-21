package com.cpifppiramide.socialMalla.posts.domain;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface PostRepository {
    void savePost(Post post);
    List<Post> filtrarPorTodo(String titulo, String descripcion, String nombreUsuario, Date fecha, String orden);


}
