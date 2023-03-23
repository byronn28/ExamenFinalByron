package com.examen.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "plato")
@Data
public class Plato {
	
	@Id
	private Long plato_id;
	private String nombre;
	private String descripcion;
	private Double precio;
	
}
