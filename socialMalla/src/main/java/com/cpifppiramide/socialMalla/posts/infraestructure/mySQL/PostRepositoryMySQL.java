package com.cpifppiramide.socialMalla.posts.infraestructure.mySQL;

import com.cpifppiramide.socialMalla.context.DBConnection;
import com.cpifppiramide.socialMalla.posts.domain.Post;
import com.cpifppiramide.socialMalla.posts.domain.PostRepository;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class PostRepositoryMySQL implements PostRepository {
    @Override
    public void savePost(Post post) {
        String sql = "INSERT INTO posts (titulo, descripcion, fechaPublicacion,numeroLikes, nombreUsuario) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = DBConnection.getInstance().prepareStatement(sql)) {

            statement.setString(1, post.getTitulo());
            statement.setString(2, post.getDescripcion());
            statement.setString(3, String.valueOf(post.getFechaPublicacion()));
            statement.setInt(4, 0);
            statement.setString(5, "alberto");
            statement.execute();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public List<Post> filtrarPorTodo(String titulo, String descripcion, String nombreUsuario, Date fechaPublicacion, String orden) {
        List<Post> posts = new ArrayList<>();

        try {

            if (orden == null) orden = "DESC";


            String sql = "SELECT * FROM posts WHERE " +
                    "(LOWER(titulo) LIKE ? OR ? IS null) " +
                    "AND (LOWER(descripcion) LIKE ? OR ? IS null) " +
                    "AND (fechaPublicacion = ? OR ? IS null) " +
                    "AND (LOWER(nombreUsuario) LIKE ? OR ? IS null)"+
                    "ORDER BY fechaPublicacion " + orden;

            PreparedStatement statement = DBConnection.getInstance().prepareStatement(sql);
            statement.setString(1, "%" + titulo + "%");
            statement.setString(2, titulo);
            statement.setString(3, "%" + descripcion + "%");
            statement.setString(4, descripcion);
            statement.setDate(5, fechaPublicacion);
            statement.setDate(6, fechaPublicacion);
            statement.setString(7,"%"+nombreUsuario+"%");
            statement.setString(8,nombreUsuario);


            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Post post = new Post();
                post.setTitulo(resultSet.getString("titulo"));
                post.setDescripcion(resultSet.getString("descripcion"));
                post.setFechaPublicacion(resultSet.getDate("fechaPublicacion").toLocalDate());
                post.setNombreUsuario(resultSet.getString("nombreUsuario"));
                post.setNumeroLikes(resultSet.getInt("numeroLikes"));
                posts.add(post);
            }
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta SQL: " + e.getMessage());
        }

        return posts;
    }
}







