/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto1_G7.Reto1_G7.Repository;
/**
 *
 * Se importan las librerias requeridas
 */
import com.Reto1_G7.Reto1_G7.Entities.User;
import com.Reto1_G7.Reto1_G7.Repository.Crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author diego
 */
@Repository
public class UserRepository {
    /**
    *
    * Se crean los metodos que ejecutara el proyecto, empleando los metodos del repositorio Crud.
    */
    @Autowired
    private UserCrudRepository userCrudRepository;
    /**
    *
    * metodo para mostrar todos los datos almacenados
    */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }
    /**
    *
    * metodo para mostrar un dato almacendado por el ID
    */
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }
    /**
    *
    * metodo para mostrar guardar un dato en la tabla
    */
    public User save(User user) {
        return userCrudRepository.save(user);
    }
    /**
    *
    * metodo para evaluar si un dato ya exite en la tabla
    */
    public boolean existeEmail(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);

        return !usuario.isEmpty();
    }
    /**
    *
    * metodo para autenticar con email y password si un usauario existe en la tabla
    */
    public Optional<User> autenticarUsuario(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
}
