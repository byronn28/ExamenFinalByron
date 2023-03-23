package com.examen.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.examen.model.Plato;


public interface PlatoRepository extends  MongoRepository<Plato, Long>{

}
