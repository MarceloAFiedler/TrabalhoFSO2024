package com.meusalugueis.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meusalugueis.demo.entity.Cliente;
import com.meusalugueis.demo.entity.Corretor;
import com.meusalugueis.demo.entity.Imovel;
import com.meusalugueis.demo.entity.Negociacao;
import com.meusalugueis.demo.entity.Projeto;

@Service
public interface NegociacaoService {

    List<Negociacao> getAll();

    Negociacao save(Negociacao negociacao);

    Negociacao delete(long id);

    Negociacao getById(long id);

    List<Negociacao> findByCorretor_da_negociacao(Corretor corretor);

    List<Negociacao> findByImovel_da_negociacao(Imovel imovel);

    List<Negociacao> findByCliente_da_negociacao(Cliente cliente);

    List<Negociacao> findByProjeto_da_negociacao(Projeto projeto);
    
}
