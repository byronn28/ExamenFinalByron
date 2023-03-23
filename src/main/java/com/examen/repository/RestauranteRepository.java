package com.examen.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.examen.model.Restaurante;


public interface RestauranteRepository extends  MongoRepository<Restaurante, Long>{

}
