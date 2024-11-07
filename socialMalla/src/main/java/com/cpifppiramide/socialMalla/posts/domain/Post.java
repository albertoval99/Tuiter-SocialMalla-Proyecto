package com.cpifppiramide.socialMalla.posts.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Post {
    private String id;
    private String titulo;
    private String descripcion;
    private LocalDate fechaPublicacion;
    private Integer numeroLikes;
    private String nombreUsuario;

    public Post(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaPublicacion = LocalDate.now();
        this.numeroLikes = 0;
        this.nombreUsuario = nombreUsuario;
    }

    public Post() {

    }


    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public Integer getNumeroLikes() {
        return numeroLikes;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public void setNumeroLikes(Integer numeroLikes) {
        this.numeroLikes = numeroLikes;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
