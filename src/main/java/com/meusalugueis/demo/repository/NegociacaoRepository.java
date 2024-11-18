package com.meusalugueis.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.meusalugueis.demo.entity.Cliente;
import com.meusalugueis.demo.entity.Corretor;
import com.meusalugueis.demo.entity.Imovel;
import com.meusalugueis.demo.entity.Negociacao;
import com.meusalugueis.demo.entity.Projeto;

@Repository
public interface NegociacaoRepository extends JpaRepository<Negociacao, Long>{

    @Query("SELECT n FROM Negociacao n WHERE n.corretor_da_negociacao = :corretor")
    List<Negociacao> findByCorretor_da_negociacao(@Param("corretor") Corretor corretor);

    @Query("SELECT n FROM Negociacao n WHERE n.cliente_da_negociacao = :cliente")
    List<Negociacao> findByCliente_da_negociacao(@Param("cliente") Cliente cliente);

    @Query("SELECT n FROM Negociacao n WHERE n.imovel_da_negociacao = :imovel")
    List<Negociacao> findByImovel_da_negociacao(@Param("imovel") Imovel imovel);

    @Query("SELECT n FROM Negociacao n WHERE n.projeto_da_negociacao = :projeto")
    List<Negociacao> findByProjeto_da_negociacao(@Param("projeto") Projeto projeto);

}
