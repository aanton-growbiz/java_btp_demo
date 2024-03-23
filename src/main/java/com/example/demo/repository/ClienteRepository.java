package com.example.demo.repository;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Clientes;

public interface ClienteRepository extends JpaRepository<Clientes, Integer> {

    @Query(value = "CALL BTP_DEMO.OBTENERCLIENTE()", nativeQuery = true)
    List<Clientes> obtenerClientes();

    /*@Query(value = "CALL BTP_DEMO.INSERTARCLIENTE(:nombre, :apellido, :email)", nativeQuery = true)
    void insertarCliente(String nombre, String apellido, String email );*/

    @Modifying
    @Transactional
    @Query(value = "CALL BTP_DEMO.INSERTARCLIENTE(:nombre, :apellido, :email)", nativeQuery = true)
    void insertarCliente(
        @Param("nombre") String nombre, 
        @Param("apellido") String apellido, 
        @Param("email") String email
    );

    @Modifying
    @Transactional
    @Query(value = "CALL BTP_DEMO.UPDATECLIENTE(:id, :nombre, :apellido, :email)", nativeQuery = true)
    void actualizarCliente(
        @Param("id") Integer id, 
        @Param("nombre") String nombre, 
        @Param("apellido") String apellido, 
        @Param("email") String email
    );
}
