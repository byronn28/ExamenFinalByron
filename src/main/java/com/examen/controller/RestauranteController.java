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

import com.examen.model.Restaurante;
import com.examen.service.RestauranteService;



@RestController
@RequestMapping("/api/restaurante")
public class RestauranteController {
	@Autowired
    RestauranteService resService;

    @GetMapping("/listar")
    public ResponseEntity<List<Restaurante>> listarCursos() {
        return new ResponseEntity<>(resService.findByAll(), 
                HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Restaurante> crearRes(
            @RequestBody Restaurante d) {
        return new ResponseEntity<>(resService.save(d), 
                HttpStatus.CREATED);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Restaurante> actualizarRes(@PathVariable Long id, @RequestBody Restaurante p) {
    	Restaurante personaENcontrada = resService.findById(id);
        if (personaENcontrada == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                personaENcontrada.setNombre(p.getNombre());
                personaENcontrada.setTelefono(p.getTelefono());
                personaENcontrada.setCorreo(p.getCorreo());
                personaENcontrada.setDireccion(p.getDireccion());
                
                return new ResponseEntity<>(resService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Restaurante> eliminarRes(@PathVariable Long id) {
    	resService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
