package com.examen.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "carta")
@Data
public class Carta {
	@Id
	private Long carta_id;
	private String nombre;
	private String categoria;
	private Integer cantidad;
	
	@DBRef
	private Plato plato;
}
