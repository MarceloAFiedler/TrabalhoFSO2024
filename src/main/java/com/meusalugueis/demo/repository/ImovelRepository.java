package com.meusalugueis.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.meusalugueis.demo.entity.Cliente;
import com.meusalugueis.demo.entity.Imovel;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long> {

    @Query("SELECT i FROM Imovel i WHERE i.cliente_proprietario = :cliente")
    List<Imovel> findByCliente_proprietario(@Param("cliente") Cliente cliente);
}
