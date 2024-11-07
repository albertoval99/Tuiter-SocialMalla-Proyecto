package com.cpifppiramide.socialMalla.posts.application;

import com.cpifppiramide.socialMalla.posts.domain.Post;
import com.cpifppiramide.socialMalla.posts.domain.PostRepository;

import java.sql.Date;
import java.time.LocalDate;


import java.util.List;

public class PostUseCases {

    private final PostRepository postRepository;


    public PostUseCases(PostRepository postRepository) {
        this.postRepository = postRepository;

    }

    public void crearPost(String titulo, String descripcion) {
        try {
            Post post = new Post(titulo, descripcion);
            postRepository.savePost(post);

        } catch (Exception e) {
            System.err.println(e.getMessage());

        }
    }

    public List<Post> listaFiltrados(String titulo, String descripcion,String nombreUsuario, LocalDate fechaPublicacion, String orden) {
        String tituloMinus;
        String descripcionMinus;
        Date fechasql;

        if (titulo != null) {
            tituloMinus = titulo.toLowerCase();
        }else {
            tituloMinus=null;
        }

        if (descripcion != null) {
            descripcionMinus = descripcion.toLowerCase();
        }else {
            descripcionMinus=null;
        }
        if (fechaPublicacion !=null){
            fechasql=Date.valueOf(fechaPublicacion);
        }else {
            fechasql= null;
        }


        return postRepository.filtrarPorTodo(tituloMinus, descripcionMinus,nombreUsuario,fechasql, orden);
    }




}
