/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto1_G7.Reto1_G7.Entities;
/**
 *
 * Se importan las librerias requeridas
 */
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author diego
 */
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
/**
 *
 * Se crea la tabla user
 */
@Table(name = "user", indexes = @Index(name = "indx_email", columnList = "user_email", unique = true))
public class User implements Serializable {
    /**
    *
    * Se generan los campos para la tabla y se definen su tipo y sus caracteristicas 
    */
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(name = "user_email", nullable = false, length = 50)
    private String email;
    @NonNull
    @Column(name = "user_password", nullable = false, length = 50)
    private String password;
    @NonNull
    @Column(name = "user_name", nullable = false, length = 80)
    private String name;  
}
