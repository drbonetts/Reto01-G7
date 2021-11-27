/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto1_G7.Reto1_G7.Service;
/**
 *
 * Se importan las librerias requeridas
 */
import com.Reto1_G7.Reto1_G7.Entities.User;
import com.Reto1_G7.Reto1_G7.Repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author diego
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    /**
    *
    * Se crea el servicio para mostrar toda la informacion
    */
    public List<User> getAll() {
        return userRepository.getAll();
    }
    /**
    *
    * Se crea el servicio para mostrar un dato almacenado por ID
    */
    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }
    /**
    *
    * Se crea el servicio para guardar un dato validando si exite para no repetir la informacion
    */
    public User registrar(User user) {
        if (user.getId() == null) {
            if (existeEmail(user.getEmail()) == false) {
                return userRepository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    /**
    *
    * Se crea el servicio para evaluar si un ususario ya esta registrado por su Email
    */
    public boolean existeEmail(String email) {
        return userRepository.existeEmail(email);
    }
    /**
    *
    * Se crea el servicio para validar si un usuario ya esta registrado por Email y Pasword
    */
    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = userRepository.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            return new User(email, password, "NO DEFINIDO");
        } else {
            return usuario.get();
        }
    } 
}
