package com.examen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.examen.model.Carta;
import com.examen.repository.CartaRepository;

@Service
public class CartaServiceImpl extends GenericServiceImpl<Carta, Long> implements CartaService{
	@Autowired
	CartaRepository carRepository;
    
    @Override
    public CrudRepository<Carta, Long> getDao() {
        return carRepository;
    } 
}
