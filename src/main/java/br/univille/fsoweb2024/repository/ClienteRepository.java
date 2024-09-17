package br.univille.fsoweb2024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.fsoweb2024.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {


}
