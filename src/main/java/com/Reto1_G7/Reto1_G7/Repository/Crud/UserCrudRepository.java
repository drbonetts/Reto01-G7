/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Reto1_G7.Reto1_G7.Repository.Crud;
/**
 *
 * Se importan las librerias requeridas
 */
import com.Reto1_G7.Reto1_G7.Entities.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author diego
 */
public interface UserCrudRepository extends CrudRepository<User, Integer> {
    /**
    *
    * Se definen los metodos Crud que se van a utilizar para validacion de la informacion.
    */
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
}
