package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class requestCliente {
    public Integer id = 0;
    public String nombre = "";
    public String apellido = "";
    public String email = "";
}
