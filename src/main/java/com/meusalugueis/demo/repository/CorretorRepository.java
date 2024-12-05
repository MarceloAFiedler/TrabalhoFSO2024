package com.meusalugueis.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meusalugueis.demo.entity.Corretor;

@Repository
public interface CorretorRepository extends JpaRepository<Corretor, Long> {
}
