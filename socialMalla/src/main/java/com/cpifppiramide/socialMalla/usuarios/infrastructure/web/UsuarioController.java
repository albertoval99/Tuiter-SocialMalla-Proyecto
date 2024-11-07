package com.cpifppiramide.socialMalla.usuarios.infrastructure.web;

import com.cpifppiramide.socialMalla.usuarios.application.UsuarioUseCases;
import com.cpifppiramide.socialMalla.usuarios.domain.Usuario;
import com.cpifppiramide.socialMalla.usuarios.domain.UsuarioRepository;
import com.cpifppiramide.socialMalla.usuarios.infrastructure.mySQL.UsuarioRepositoryMySQL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
@Controller /**OJO NO OLVIDAR**/
public class UsuarioController {

    /**Asi sera el constructor**/
     private UsuarioUseCases usuarioUseCases = new UsuarioUseCases(new UsuarioRepositoryMySQL());


    @GetMapping("/createAccount")
    public String createAccount(Model model){
        model.addAttribute("usuario", new Usuario());
        return "createAccount";
    }
    @PostMapping("/createAccount")
    public String registro(
            Model model,
            /**El value tiene q ser igual que el name del input**/
            @RequestParam(value = "nombre") String nombre,
            @RequestParam(value = "apellidos") String apellidos,
            @RequestParam(value = "nombreUsuario") String nombreUsuario,
            @RequestParam(value = "diaNacimiento") LocalDate diaNacimiento,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "numeroTelefono") String numeroTelefono) {

        try {
            usuarioUseCases.registro(nombre, apellidos, nombreUsuario, diaNacimiento, password, numeroTelefono);
            return "login";
        } catch (Exception e) {
            model.addAttribute("error", "Username already exists, please try again.");
            return "createAccount";
        }
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String iniciarSesion(Model model,
                                @RequestParam( value = "nombreUsuario") String nombreUsuario,
                                @RequestParam(value = "password") String password){

        try{
            Usuario usuario = usuarioUseCases.iniciarSesion(nombreUsuario,password);
            model.addAttribute("usuario",usuario);
            return "index";
        }catch (Exception e){
            model.addAttribute("error","Incorrect username or pasword");
            return "login";
        }

    }
}
