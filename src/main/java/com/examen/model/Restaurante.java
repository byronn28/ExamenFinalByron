package com.examen.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "restaurante")
@Data


public class Restaurante {
	@Id
	private Long restaurante_id;
	private String nombre;
	private String telefono;
	private String direccion;
	private String correo;
	@DBRef
	private Cliente cliente;
	@DBRef
	private Carta carta;
}
