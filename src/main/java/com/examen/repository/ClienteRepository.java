package com.examen.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.examen.model.Cliente;


public interface ClienteRepository extends  MongoRepository<Cliente, Long>{

}
