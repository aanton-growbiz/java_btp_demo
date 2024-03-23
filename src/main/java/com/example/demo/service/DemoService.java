package com.example.demo.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Clientes;
import com.example.demo.repository.ClienteRepository;

@Service
public class DemoService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public DemoService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Clientes> getClientes() {
        List<Clientes> clientes = new ArrayList<>();
        clientes.add(new Clientes(1, "Juan", "Pérez", "juan@example.com"));
        clientes.add(new Clientes(2, "María", "Gómez", "maria@example.com"));
        clientes.add(new Clientes(3, "Carlos", "López", "carlos@example.com"));
        return clientes;
    }

    public List<Clientes> obtenerClientes() {
        return clienteRepository.obtenerClientes();
    }

    public void insertarCliente(String nombre, String apellido, String email) {
        clienteRepository.insertarCliente(nombre, apellido, email);
    }

    public void actualizarCliente(Integer id, String nombre, String apellido, String email) {
        clienteRepository.actualizarCliente(id, nombre, apellido, email);
    }
}