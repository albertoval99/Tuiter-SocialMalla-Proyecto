package com.cpifppiramide.socialMalla.usuarios.domain;

import com.cpifppiramide.socialMalla.posts.domain.Post;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Usuario {
    private String id;
    private String nombre;
    private String apellidos;
    private String nombreUsuario;
    private LocalDate diaNacimiento;
    private String password;
    private String numeroTelefono;
    private String email;
    private List<Post> postsUsuario;

    public Usuario(String id, String nombre, String apellidos, String nombreUsuario, LocalDate diaNacimiento, String password, String numeroTelefono,String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nombreUsuario = nombreUsuario;
        this.diaNacimiento = diaNacimiento;
        this.password = password;
        this.numeroTelefono = numeroTelefono;
        this.email =email;
        this.postsUsuario = new LinkedList<>();
    }

    public Usuario() {
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public LocalDate getDiaNacimiento() {
        return diaNacimiento;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getPassword() {
        return password;
    }

    public List<Post> getPostsUsuario() {
        return postsUsuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setDiaNacimiento(LocalDate diaNacimiento) {
        this.diaNacimiento = diaNacimiento;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
