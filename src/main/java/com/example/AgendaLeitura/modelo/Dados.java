package com.example.AgendaLeitura.modelo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Dados {

	public int id;
	public String titulo;
	public String autor;
	public int rating;
	public String flag;
	
	
}
