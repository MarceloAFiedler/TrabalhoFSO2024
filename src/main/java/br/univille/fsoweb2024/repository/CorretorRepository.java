package br.univille.fsoweb2024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.fsoweb2024.entity.Corretor;

@Repository
public interface CorretorRepository extends JpaRepository<Corretor,Long>{
    
}
