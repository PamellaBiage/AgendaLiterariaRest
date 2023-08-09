package com.example.AgendaLeitura.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AgendaLeitura.modelo.Agenda;
import com.example.AgendaLeitura.modelo.Dados;
import com.example.AgendaLeitura.repository.AgendaRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("agenda")
public class AgendaController {
	
	@Autowired
	AgendaRepository repository;
		
	@GetMapping()
	@CrossOrigin(origins = "http://localhost:8080")
	public List<Agenda> listar(@PageableDefault(sort= {"autor"}) Pageable paginacao){
		return repository.findAll();
	}
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody Dados dados) {
		repository.save(new Agenda(dados)).flag();
		System.out.println(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void deletar(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@PutMapping
	@Transactional
	public void editar(@RequestBody Dados dados) {
		var agenda = repository.getReferenceById((long)dados.id);
		agenda.atualizar(dados);
	}
	

}
