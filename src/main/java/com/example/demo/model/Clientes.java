package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Entity
public class Clientes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CLIENTEID;

    private String NOMBRE;
    private String APELLIDO;
    private String EMAIL;

    public Clientes() {
    }

    public Clientes(Integer CLIENTEID, String NOMBRE, String APELLIDO, String EMAIL) {
        this.CLIENTEID = CLIENTEID;
        this.NOMBRE = NOMBRE;
        this.APELLIDO = APELLIDO;
        this.EMAIL = EMAIL;
    }
}
