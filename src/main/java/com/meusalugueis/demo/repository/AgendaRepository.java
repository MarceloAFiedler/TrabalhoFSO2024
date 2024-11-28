package com.meusalugueis.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meusalugueis.demo.entity.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long>{

}
