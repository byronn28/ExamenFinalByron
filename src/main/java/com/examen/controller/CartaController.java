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

import com.examen.model.Carta;
import com.examen.service.CartaService;



@RestController
@RequestMapping("/api/carta")
public class CartaController {
	@Autowired
    CartaService carService;

    @GetMapping("/listar")
    public ResponseEntity<List<Carta>> listarCursos() {
        return new ResponseEntity<>(carService.findByAll(), 
                HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Carta> crearProducto(
            @RequestBody Carta d) {
        return new ResponseEntity<>(carService.save(d), 
                HttpStatus.CREATED);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Carta> actualizarProducto(@PathVariable Long id, @RequestBody Carta p) {
    	Carta personaENcontrada = carService.findById(id);
        if (personaENcontrada == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                personaENcontrada.setNombre(p.getNombre());
                personaENcontrada.setCategoria(p.getCategoria());
                personaENcontrada.setCantidad(p.getCantidad());
                //personaENcontrada.setCorreo(p.getCorreo());
                
                return new ResponseEntity<>(carService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Carta> eliminarProducto(@PathVariable Long id) {
    	carService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
