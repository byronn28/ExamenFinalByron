package com.examen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.examen.model.Cliente;
import com.examen.repository.ClienteRepository;


@Service
public class ClienteServiceImpl extends GenericServiceImpl<Cliente, Long> implements ClienteService{
	@Autowired
	ClienteRepository cliRepository;
    
    @Override
    public CrudRepository<Cliente, Long> getDao() {
        return cliRepository;
    } 
}
