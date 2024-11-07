package com.cpifppiramide.socialMalla.usuarios.infrastructure.mySQL;

import com.cpifppiramide.socialMalla.context.DBConnection;
import com.cpifppiramide.socialMalla.usuarios.domain.Usuario;
import com.cpifppiramide.socialMalla.usuarios.domain.UsuarioRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UsuarioRepositoryMySQL implements UsuarioRepository {

    @Override
    public void saveUsuario(Usuario usuario) {
        try {
            String sql = "insert into usuarios " +
                    "(nombre, apellidos, nombreUsuario, diaNacimiento, password, numeroTelefono)" +
                    " values (?,?,?,?,?,?)";
            PreparedStatement statement = DBConnection.getInstance().prepareStatement(sql);
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getApellidos());
            statement.setString(3,usuario.getNombreUsuario());
            statement.setString(4, String.valueOf(usuario.getDiaNacimiento()));
            statement.setString(5,usuario.getPassword());
            statement.setString(6, usuario.getNumeroTelefono());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public Optional<Usuario> buscarPorNombreUsuario(String nombreUsuario) {
        String sql = "select nombreUsuario, password from usuarios where nombreUsuario = ?";
        try {
            PreparedStatement statement = DBConnection.getInstance().prepareStatement(sql);
            statement.setString(1, nombreUsuario);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Usuario usuario = new Usuario();
                usuario.setNombreUsuario(resultSet.getString("nombreUsuario"));
                usuario.setPassword(resultSet.getString("password"));
                return Optional.of(usuario);
            }
        } catch (SQLException e) {
            throw new RuntimeException("ERROR al encontrar el usuario",e);
        }
        return Optional.empty();
    }



}
