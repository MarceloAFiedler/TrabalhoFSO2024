package com.meusalugueis.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.meusalugueis.demo.entity.Notificacao;

@Service
public interface NotificacaoService {

    void gerarNotificacoesDeMetas();  // Cria as notificações baseadas no projeto

    List<Notificacao> listarNotificacoes();  // Exibe todas as notificações (pode ser usada na interface) 
}

