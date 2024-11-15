package com.meusalugueis.demo.service;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.meusalugueis.demo.entity.Notificacao;

@Service
public interface NotificacaoService {

    void gerarNotificacoesDeMetas();  // Cria as notificações baseadas na meta

    void gerarNotificacoesDeStatusDeProjeto();  // Cria as notificações baseadas no status do projeto

    void gerarNotificacoesDePagamentoDeProjeto();   // Cria as notificações baseadas no status de pagamento do projeto

    void deleteByOrigem(int origem);

    List<Notificacao> listarNotificacoes();  // Exibe todas as notificações (pode ser usada na interface)

}

