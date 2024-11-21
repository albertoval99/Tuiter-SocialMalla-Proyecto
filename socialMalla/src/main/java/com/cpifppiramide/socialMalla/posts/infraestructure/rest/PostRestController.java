package com.cpifppiramide.socialMalla.posts.infraestructure.rest;

import com.cpifppiramide.socialMalla.posts.application.PostUseCases;
import com.cpifppiramide.socialMalla.posts.domain.Post;
import com.cpifppiramide.socialMalla.posts.infraestructure.mySQL.PostRepositoryMySQL;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class PostRestController {
    private PostUseCases postUseCases = new PostUseCases(new PostRepositoryMySQL());

    @GetMapping("/api")
    public List<Post> filtrarPosts(
            @RequestParam(name = "nombreUsuario", required = false) String nombreUsuario,
            @RequestParam(name = "titulo", required = false) String titulo,
            @RequestParam(name = "descripcion", required = false) String descripcion,
            @RequestParam(name = "fecha", required = false) LocalDate fecha,
            @RequestParam(name = "ordenFecha", required = false) String ordenFecha,
            Model model) {

        List<Post> posts = postUseCases.listaFiltrados(titulo, descripcion, nombreUsuario, fecha, ordenFecha);

        model.addAttribute("posts", posts);
        return posts;

    }
}