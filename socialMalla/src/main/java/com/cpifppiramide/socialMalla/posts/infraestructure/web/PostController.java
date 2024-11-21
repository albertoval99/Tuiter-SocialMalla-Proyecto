package com.cpifppiramide.socialMalla.posts.infraestructure.web;

import com.cpifppiramide.socialMalla.posts.application.PostUseCases;
import com.cpifppiramide.socialMalla.posts.domain.Post;
import com.cpifppiramide.socialMalla.posts.domain.PostRepository;
import com.cpifppiramide.socialMalla.posts.infraestructure.mySQL.PostRepositoryMySQL;
import com.cpifppiramide.socialMalla.usuarios.application.UsuarioUseCases;
import com.cpifppiramide.socialMalla.usuarios.domain.Usuario;
import com.cpifppiramide.socialMalla.usuarios.domain.UsuarioRepository;
import com.cpifppiramide.socialMalla.usuarios.infrastructure.mySQL.UsuarioRepositoryMySQL;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;


@Controller
public class PostController {

    private PostUseCases postUseCases = new PostUseCases(new PostRepositoryMySQL());


    @GetMapping("/newSocial")
    public String newSocial() {
        return "newSocial";
    }


    @PostMapping("/newSocial")
    public String crearPost(
            @RequestParam String titulo,
            @RequestParam String descripcion
    ) {
            postUseCases.crearPost(titulo, descripcion);
            return "redirect:/";
    }

    @GetMapping("/")
    public String filtrarPosts(
            @RequestParam(name = "nombreUsuario", required = false) String nombreUsuario,
            @RequestParam(name = "titulo", required = false) String titulo,
            @RequestParam(name = "descripcion", required = false) String descripcion,
            @RequestParam(name = "fecha", required = false) LocalDate fecha,
            @RequestParam(name = "ordenFecha", required = false) String ordenFecha,
            Model model) {

            List<Post> posts = postUseCases.listaFiltrados(titulo, descripcion, nombreUsuario, fecha, ordenFecha);

            model.addAttribute("posts", posts);
            return "index";
    }



}
