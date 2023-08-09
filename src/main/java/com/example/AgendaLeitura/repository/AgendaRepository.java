package com.example.AgendaLeitura.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.AgendaLeitura.modelo.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
	

}
