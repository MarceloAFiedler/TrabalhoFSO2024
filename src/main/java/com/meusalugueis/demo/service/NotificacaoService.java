package com.meusalugueis.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meusalugueis.demo.entity.Notificacao;

@Service
public interface NotificacaoService {

    void gerarNotificacoesDeMetas();

    void gerarNotificacoesDeStatusDeProjeto();

    void gerarNotificacoesDePagamentoDeProjeto();
       
    void gerarNotificacoesDeNegociacoes();

    void deleteByOrigem(int origem);

    List<Notificacao> listarNotificacoes();

}

