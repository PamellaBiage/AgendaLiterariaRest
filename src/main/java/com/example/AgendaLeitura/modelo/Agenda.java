package com.example.AgendaLeitura.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="livros")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Agenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String autor;
	private String titulo;
	private int rating;
	private String flag;
	
	public Agenda() {
		super();
	}
	
	public Agenda(Dados dados) {
		this.id = dados.id;
		this.autor = dados.autor;
		this.titulo = dados.titulo;
		this.rating = dados.rating;
		this.flag = dados.flag;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public void flag() {
		if(this.flag.equalsIgnoreCase("S")) {
			System.out.println("livros lidos");
		}if(this.flag.equalsIgnoreCase("N")) {
			System.out.println("livros para ler");
		}
	}
	
	public void atualizar( Dados dados) {
		if(dados.titulo != null) {
			this.titulo = dados.titulo;
		}
		if(dados.autor != null) {
			this.autor = dados.autor;
		}
		if(dados.rating != 0) {
			this.rating = dados.rating;
		}
		if(dados.flag != null) {
			this.flag = dados.flag;
		}
	}
	

}
