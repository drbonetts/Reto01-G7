/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto1_G7.Reto1_G7.Controller;
/**
 *
 * Se importan las librerias requeridas
 */
import com.Reto1_G7.Reto1_G7.Entities.User;
import com.Reto1_G7.Reto1_G7.Service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author diego
 */
@RestController
/**
 *
 * Se define la direccion para el proyecto
 */
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;
    /**
    *
    * Se define la direccion para el servicio get
    */
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }
    /**
    *
    * Se define la direccion para el servicio post
    */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User registrar(@RequestBody User user) {
        return userService.registrar(user);
    }
    /**
    *
    * Se define la direccion para el servicio get validando usisario por Email y Password 
    */
    @GetMapping("/{email}/{password}")
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.autenticarUsuario(email, password);
    }
    /**
    *
    * Se define la direccion para el servicio get evaluando si el Email ya esta registrado
    */
    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return userService.existeEmail(email);
    }
    
    
}
