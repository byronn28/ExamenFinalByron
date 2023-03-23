package com.examen.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document(collection = "cliente")
@Data
public class Cliente {
	
	@Id
	private Long cliente_id;
	private String nombre;
	private String apellido;
	private String cedula;
	private String correo;
}
