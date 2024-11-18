package com.meusalugueis.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meusalugueis.demo.entity.Notificacao;

@Service
public interface NotificacaoService {

    void gerarNotificacoesDeMetas();  // Cria as notificações baseadas na data limite da meta

    void gerarNotificacoesDeStatusDeProjeto();  // Cria as notificações baseadas no status do projeto

    void gerarNotificacoesDePagamentoDeProjeto();
       
    void gerarNotificacoesDeNegociacoes();   // Cria as notificações baseadas em fase da negociação

    void deleteByOrigem(int origem);

    List<Notificacao> listarNotificacoes();  // Exibe todas as notificações (pode ser usada na interface)

}

