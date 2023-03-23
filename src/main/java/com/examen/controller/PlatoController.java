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

import com.examen.model.Plato;
import com.examen.service.PlatoService;



@RestController
@RequestMapping("/api/plato")
public class PlatoController {
	@Autowired
    PlatoService plaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Plato>> listarCursos() {
        return new ResponseEntity<>(plaService.findByAll(), 
                HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Plato> crearProducto(
            @RequestBody Plato d) {
        return new ResponseEntity<>(plaService.save(d), 
                HttpStatus.CREATED);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Plato> actualizarProducto(@PathVariable Long id, @RequestBody Plato p) {
    	Plato personaENcontrada = plaService.findById(id);
        if (personaENcontrada == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                personaENcontrada.setNombre(p.getNombre());
                personaENcontrada.setDescripcion(p.getDescripcion());
                personaENcontrada.setPrecio(p.getPrecio());
                
                return new ResponseEntity<>(plaService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Plato> eliminarProducto(@PathVariable Long id) {
    	plaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
