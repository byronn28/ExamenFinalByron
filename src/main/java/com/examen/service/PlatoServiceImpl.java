package com.examen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.examen.model.Plato;
import com.examen.repository.PlatoRepository;


@Service
public class PlatoServiceImpl extends GenericServiceImpl<Plato, Long> implements PlatoService{
	@Autowired
	PlatoRepository plaRepository;
    
    @Override
    public CrudRepository<Plato, Long> getDao() {
        return plaRepository;
    } 
}

