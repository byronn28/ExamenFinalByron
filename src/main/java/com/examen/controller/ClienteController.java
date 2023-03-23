package com.examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.model.Cliente;
import com.examen.service.ClienteService;



@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	@Autowired
    ClienteService cliService;

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listarCliente() {
        return new ResponseEntity<>(cliService.findByAll(), 
                HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Cliente> crearCliente(
            @RequestBody Cliente d) {
        return new ResponseEntity<>(cliService.save(d), 
                HttpStatus.CREATED);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente p) {
    	Cliente personaENcontrada = cliService.findById(id);
        if (personaENcontrada == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                personaENcontrada.setNombre(p.getNombre());
                personaENcontrada.setApellido(p.getApellido());
                personaENcontrada.setCedula(p.getCedula());
                personaENcontrada.setCorreo(p.getCorreo());
                
                return new ResponseEntity<>(cliService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Cliente> eliminarCliente(@PathVariable Long id) {
    	cliService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
