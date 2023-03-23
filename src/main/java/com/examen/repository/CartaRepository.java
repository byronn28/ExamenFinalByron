package com.examen.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.examen.model.Carta;


public interface CartaRepository extends  MongoRepository<Carta, Long>{

}
