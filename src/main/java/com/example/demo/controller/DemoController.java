package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Clientes;
import com.example.demo.model.requestCliente;
import com.example.demo.model.response;
import com.example.demo.service.DemoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class DemoController {

    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/clientes")
    public List<Clientes> getClientes() {
        return demoService.obtenerClientes();
    }

    @PostMapping("/insertarCliente")
    public response insertarCliente(@RequestBody requestCliente obj) {
        
        try {
            demoService.insertarCliente(obj.nombre, obj.apellido, obj.email);    
            response responseOk = new response("00","Ok");
            return responseOk;    
            
        } catch (Exception e) {
            response responseError = new response("01",e.getMessage());
            return responseError;    
        }
        
    }

    @PostMapping("/actualizarCliente")
    public response actualizarCliente(@RequestBody requestCliente obj) {
        
        try {
            demoService.actualizarCliente(obj.id, obj.nombre, obj.apellido, obj.email);    
            response responseOk = new response("00","Ok");
            return responseOk;    
            
        } catch (Exception e) {
            response responseError = new response("01",e.getMessage());
            return responseError;    
        }
        
    }

}