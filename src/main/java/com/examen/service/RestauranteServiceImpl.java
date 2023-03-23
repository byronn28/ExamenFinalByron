package com.examen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.examen.model.Restaurante;
import com.examen.repository.RestauranteRepository;

@Service
public class RestauranteServiceImpl extends GenericServiceImpl<Restaurante, Long> implements RestauranteService{

	@Autowired
	RestauranteRepository resRepository;
    
    @Override
    public CrudRepository<Restaurante, Long> getDao() {
        return resRepository;
    } 

}
