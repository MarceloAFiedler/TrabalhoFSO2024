package com.meusalugueis.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.meusalugueis.demo.entity.Cliente;
import com.meusalugueis.demo.entity.Corretor;
import com.meusalugueis.demo.entity.Imovel;
import com.meusalugueis.demo.entity.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long>{

    @Query("SELECT p FROM Projeto p WHERE p.cliente_do_projeto = :cliente")
    List<Projeto> findByCliente_do_projeto(@Param("cliente") Cliente cliente);

    @Query("SELECT p FROM Projeto p WHERE p.corretor_do_projeto = :corretor")
    List<Projeto> findByCorretor_do_projeto(@Param("corretor") Corretor corretor);

    @Query("SELECT p FROM Projeto p WHERE p.imovel_do_projeto = :imovel")
    List<Projeto> findByImovel_do_projeto(@Param("imovel") Imovel imovel);
}
