package com.meusalugueis.demo.serviceimpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meusalugueis.demo.entity.Meta;
import com.meusalugueis.demo.entity.Negociacao;
import com.meusalugueis.demo.entity.Notificacao;
import com.meusalugueis.demo.entity.Projeto;
import com.meusalugueis.demo.repository.MetaRepository;
import com.meusalugueis.demo.repository.NegociacaoRepository;
import com.meusalugueis.demo.repository.NotificacaoRepository;
import com.meusalugueis.demo.repository.ProjetoRepository;
import com.meusalugueis.demo.service.NotificacaoService;

@Service
public class NotificacaoServiceImpl implements NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private MetaRepository metaRepository;

    @Autowired NegociacaoRepository negociacaoRepository;

    @Override
    public void gerarNotificacoesDeMetas() {

        deleteByOrigem(1); // tem que limpar sabudega sempre!!! 
        
        var listaDeMetas = metaRepository.findAll();

        Date DATA_DE_HOJE_util_Date = new Date();
        LocalDate DATE_DE_HOJE_LocalDate = DATA_DE_HOJE_util_Date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("DATE_DE_HOJE_LocalDate var =" + DATE_DE_HOJE_LocalDate);
        System.out.println("DATE_DE_HOJE_LocalDate type =" + DATE_DE_HOJE_LocalDate.getClass().getName());
        for(Meta meta : listaDeMetas){
            Date DATA_FUTURA_sql_Date = meta.getData_limite();
            System.out.println("DATA_FUTURA_sql_Date =" + DATA_FUTURA_sql_Date);

            Date DATA_FUTURA_util_Date = new Date(DATA_FUTURA_sql_Date.getTime());

            LocalDate DATA_FUTURA_LocalDate = DATA_FUTURA_util_Date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            System.out.println("DATA_FUTURA_LocalDate var =" + DATA_FUTURA_LocalDate);
            System.out.println("DATA_FUTURA_LocalDate type =" + DATA_FUTURA_LocalDate.getClass().getName());
            
            long diasDiferenca = ChronoUnit.DAYS.between(DATE_DE_HOJE_LocalDate, DATA_FUTURA_LocalDate);

            System.out.println("Dias de Diferença: " + diasDiferenca);

            // ------- Lógica de gerar as Notificações

            if (diasDiferenca >= 14) {
                System.out.println("Tipo 5");
                Notificacao noti = new Notificacao();
                noti.setNome_da_notificacao(meta.getNome());
                noti.setTipo_de_notificacao(5);
                noti.setData_de_notificacao(Date.from(DATA_FUTURA_LocalDate.minusDays(14).
                                                                            atStartOfDay(ZoneId.systemDefault()).
                                                                            toInstant()));
                noti.setOrigem(1);
                notificacaoRepository.save(noti);
            }
            if (diasDiferenca >= 7) {
                System.out.println("Tipo 4");
                Notificacao noti = new Notificacao();
                noti.setNome_da_notificacao(meta.getNome());
                noti.setTipo_de_notificacao(4);
                noti.setData_de_notificacao(Date.from(DATA_FUTURA_LocalDate.minusDays(7).
                                                                            atStartOfDay(ZoneId.systemDefault()).
                                                                            toInstant()));
                noti.setOrigem(1);
                notificacaoRepository.save(noti);
            }
            if (diasDiferenca >= 3) {
                System.out.println("Tipo 3");
                Notificacao noti = new Notificacao();
                noti.setNome_da_notificacao(meta.getNome());
                noti.setTipo_de_notificacao(3);
                noti.setData_de_notificacao(Date.from(DATA_FUTURA_LocalDate.minusDays(3).
                                                                            atStartOfDay(ZoneId.systemDefault()).
                                                                            toInstant()));
                noti.setOrigem(1);
                notificacaoRepository.save(noti);
            }
            if (diasDiferenca >= 1) {
                System.out.println("Tipo 2");
                Notificacao noti = new Notificacao();
                noti.setNome_da_notificacao(meta.getNome());
                noti.setTipo_de_notificacao(2);
                noti.setData_de_notificacao(Date.from(DATA_FUTURA_LocalDate.minusDays(1).
                                                                            atStartOfDay(ZoneId.systemDefault()).
                                                                            toInstant()));
                noti.setOrigem(1);
                notificacaoRepository.save(noti);
            }
            if (diasDiferenca >= 0) {
                System.out.println("Tipo 1");
                Notificacao noti = new Notificacao();
                noti.setNome_da_notificacao(meta.getNome());
                noti.setTipo_de_notificacao(1);
                noti.setData_de_notificacao(Date.from(DATA_FUTURA_LocalDate.atStartOfDay(ZoneId.systemDefault()).
                                                                            toInstant()));
                noti.setOrigem(1);
                notificacaoRepository.save(noti);
            }
        
        }
    }

    @Override 
    public void gerarNotificacoesDeNegociacoes() {
            notificacaoRepository.deleteByOrigem(4);  
            
            var listaDeNegociacoes = negociacaoRepository.findAll();

        Date DATA_DE_HOJE_util_Date = new Date();
        LocalDate DATE_DE_HOJE_LocalDate = DATA_DE_HOJE_util_Date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("DATE_DE_HOJE_LocalDate var =" + DATE_DE_HOJE_LocalDate);
        System.out.println("DATE_DE_HOJE_LocalDate type =" + DATE_DE_HOJE_LocalDate.getClass().getName());
        for(Negociacao negociacao : listaDeNegociacoes){
            Date DATA_FUTURA_sql_Date = negociacao.getData_de_checkpoint_da_fase();
            System.out.println("DATA_FUTURA_sql_Date =" + DATA_FUTURA_sql_Date);

            Date DATA_FUTURA_util_Date = new Date(DATA_FUTURA_sql_Date.getTime());

            LocalDate DATA_FUTURA_LocalDate = DATA_FUTURA_util_Date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            System.out.println("DATA_FUTURA_LocalDate var =" + DATA_FUTURA_LocalDate);
            System.out.println("DATA_FUTURA_LocalDate type =" + DATA_FUTURA_LocalDate.getClass().getName());
            
            long diasDiferenca = ChronoUnit.DAYS.between(DATE_DE_HOJE_LocalDate, DATA_FUTURA_LocalDate);

            System.out.println("Dias de Diferença: " + diasDiferenca);

            // ------- Lógica de gerar as Notificações

            if (diasDiferenca >= 14) {
                System.out.println("Tipo 5");
                Notificacao noti = new Notificacao();
                noti.setNome_da_notificacao(negociacao.getNome());
                noti.setTipo_de_notificacao(5);
                noti.setData_de_notificacao(Date.from(DATA_FUTURA_LocalDate.minusDays(14).
                                                                            atStartOfDay(ZoneId.systemDefault()).
                                                                            toInstant()));
                noti.setOrigem(4);
                notificacaoRepository.save(noti);
            }
            if (diasDiferenca >= 7) {
                System.out.println("Tipo 4");
                Notificacao noti = new Notificacao();
                noti.setNome_da_notificacao(negociacao.getNome());
                noti.setTipo_de_notificacao(4);
                noti.setData_de_notificacao(Date.from(DATA_FUTURA_LocalDate.minusDays(7).
                                                                            atStartOfDay(ZoneId.systemDefault()).
                                                                            toInstant()));
                noti.setOrigem(4);
                notificacaoRepository.save(noti);
            }
            if (diasDiferenca >= 3) {
                System.out.println("Tipo 3");
                Notificacao noti = new Notificacao();
                noti.setNome_da_notificacao(negociacao.getNome());
                noti.setTipo_de_notificacao(3);
                noti.setData_de_notificacao(Date.from(DATA_FUTURA_LocalDate.minusDays(3).
                                                                            atStartOfDay(ZoneId.systemDefault()).
                                                                            toInstant()));
                noti.setOrigem(4);
                notificacaoRepository.save(noti);
            }
            if (diasDiferenca >= 1) {
                System.out.println("Tipo 2");
                Notificacao noti = new Notificacao();
                noti.setNome_da_notificacao(negociacao.getNome());
                noti.setTipo_de_notificacao(2);
                noti.setData_de_notificacao(Date.from(DATA_FUTURA_LocalDate.minusDays(1).
                                                                            atStartOfDay(ZoneId.systemDefault()).
                                                                            toInstant()));
                noti.setOrigem(4);
                notificacaoRepository.save(noti);
            }
            if (diasDiferenca >= 0) {
                System.out.println("Tipo 1");
                Notificacao noti = new Notificacao();
                noti.setNome_da_notificacao(negociacao.getNome());
                noti.setTipo_de_notificacao(1);
                noti.setData_de_notificacao(Date.from(DATA_FUTURA_LocalDate.atStartOfDay(ZoneId.systemDefault()).
                                                                            toInstant()));
                noti.setOrigem(4);
                notificacaoRepository.save(noti);
            }
        
        }
    }

    @Override
    public void gerarNotificacoesDeStatusDeProjeto() {
        notificacaoRepository.deleteByOrigem(2);  
            
        var listaDeStatusProjeto = projetoRepository.findAll();

        Date DATA_DE_HOJE_util_Date = new Date();
        LocalDate DATE_DE_HOJE_LocalDate = DATA_DE_HOJE_util_Date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("DATE_DE_HOJE_LocalDate var =" + DATE_DE_HOJE_LocalDate);
        System.out.println("DATE_DE_HOJE_LocalDate type =" + DATE_DE_HOJE_LocalDate.getClass().getName());
        for(Projeto projeto : listaDeStatusProjeto){
            Date DATA_FUTURA_sql_Date = projeto.getData_de_checkpoint_status_do_projeto();
            System.out.println("DATA_FUTURA_sql_Date =" + DATA_FUTURA_sql_Date);

            Date DATA_FUTURA_util_Date = new Date(DATA_FUTURA_sql_Date.getTime());

            LocalDate DATA_FUTURA_LocalDate = DATA_FUTURA_util_Date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            System.out.println("DATA_FUTURA_LocalDate var =" + DATA_FUTURA_LocalDate);
            System.out.println("DATA_FUTURA_LocalDate type =" + DATA_FUTURA_LocalDate.getClass().getName());
            
            long diasDiferenca = ChronoUnit.DAYS.between(DATE_DE_HOJE_LocalDate, DATA_FUTURA_LocalDate);

            System.out.println("Dias de Diferença: " + diasDiferenca);

            // ------- Lógica de gerar as Notificações

            if (diasDiferenca >= 14) {
                System.out.println("Tipo 5");
                Notificacao noti = new Notificacao();
                noti.setNome_da_notificacao(projeto.getNome());
                noti.setTipo_de_notificacao(5);
                noti.setData_de_notificacao(Date.from(DATA_FUTURA_LocalDate.minusDays(14).
                                                                            atStartOfDay(ZoneId.systemDefault()).
                                                                            toInstant()));
                noti.setOrigem(2);
                notificacaoRepository.save(noti);
            }
            if (diasDiferenca >= 7) {
                System.out.println("Tipo 4");
                Notificacao noti = new Notificacao();
                noti.setNome_da_notificacao(projeto.getNome());
                noti.setTipo_de_notificacao(4);
                noti.setData_de_notificacao(Date.from(DATA_FUTURA_LocalDate.minusDays(7).
                                                                            atStartOfDay(ZoneId.systemDefault()).
                                                                            toInstant()));
                noti.setOrigem(2);
                notificacaoRepository.save(noti);
            }
            if (diasDiferenca >= 3) {
                System.out.println("Tipo 3");
                Notificacao noti = new Notificacao();
                noti.setNome_da_notificacao(projeto.getNome());
                noti.setTipo_de_notificacao(3);
                noti.setData_de_notificacao(Date.from(DATA_FUTURA_LocalDate.minusDays(3).
                                                                            atStartOfDay(ZoneId.systemDefault()).
                                                                            toInstant()));
                noti.setOrigem(2);
                notificacaoRepository.save(noti);
            }
            if (diasDiferenca >= 1) {
                System.out.println("Tipo 2");
                Notificacao noti = new Notificacao();
                noti.setNome_da_notificacao(projeto.getNome());
                noti.setTipo_de_notificacao(2);
                noti.setData_de_notificacao(Date.from(DATA_FUTURA_LocalDate.minusDays(1).
                                                                            atStartOfDay(ZoneId.systemDefault()).
                                                                            toInstant()));
                noti.setOrigem(2);
                notificacaoRepository.save(noti);
            }
            if (diasDiferenca >= 0) {
                System.out.println("Tipo 1");
                Notificacao noti = new Notificacao();
                noti.setNome_da_notificacao(projeto.getNome());
                noti.setTipo_de_notificacao(1);
                noti.setData_de_notificacao(Date.from(DATA_FUTURA_LocalDate.atStartOfDay(ZoneId.systemDefault()).
                                                                            toInstant()));
                noti.setOrigem(2);
                notificacaoRepository.save(noti);
            }
        
        }
        }

    @Override
    public void gerarNotificacoesDePagamentoDeProjeto() {
        notificacaoRepository.deleteByOrigem(3);  
            
        var listaDeStatusProjeto = projetoRepository.findAll();

        Date DATA_DE_HOJE_util_Date = new Date();
        LocalDate DATE_DE_HOJE_LocalDate = DATA_DE_HOJE_util_Date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("DATE_DE_HOJE_LocalDate var =" + DATE_DE_HOJE_LocalDate);
        System.out.println("DATE_DE_HOJE_LocalDate type =" + DATE_DE_HOJE_LocalDate.getClass().getName());
        for(Projeto projeto : listaDeStatusProjeto){
            Date DATA_FUTURA_sql_Date = projeto.getData_de_checkpoint_status_do_pagamento();
            System.out.println("DATA_FUTURA_sql_Date =" + DATA_FUTURA_sql_Date);

            Date DATA_FUTURA_util_Date = new Date(DATA_FUTURA_sql_Date.getTime());

            LocalDate DATA_FUTURA_LocalDate = DATA_FUTURA_util_Date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            System.out.println("DATA_FUTURA_LocalDate var =" + DATA_FUTURA_LocalDate);
            System.out.println("DATA_FUTURA_LocalDate type =" + DATA_FUTURA_LocalDate.getClass().getName());
            
            long diasDiferenca = ChronoUnit.DAYS.between(DATE_DE_HOJE_LocalDate, DATA_FUTURA_LocalDate);

            System.out.println("Dias de Diferença: " + diasDiferenca);

            // ------- Lógica de gerar as Notificações

            if (diasDiferenca >= 14) {
                System.out.println("Tipo 5");
                Notificacao noti = new Notificacao();
                noti.setNome_da_notificacao(projeto.getNome());
                noti.setTipo_de_notificacao(5);
                noti.setData_de_notificacao(Date.from(DATA_FUTURA_LocalDate.minusDays(14).
                                                                            atStartOfDay(ZoneId.systemDefault()).
                                                                            toInstant()));
                noti.setOrigem(3);
                notificacaoRepository.save(noti);
            }
            if (diasDiferenca >= 7) {
                System.out.println("Tipo 4");
                Notificacao noti = new Notificacao();
                noti.setNome_da_notificacao(projeto.getNome());
                noti.setTipo_de_notificacao(4);
                noti.setData_de_notificacao(Date.from(DATA_FUTURA_LocalDate.minusDays(7).
                                                                            atStartOfDay(ZoneId.systemDefault()).
                                                                            toInstant()));
                noti.setOrigem(3);
                notificacaoRepository.save(noti);
            }
            if (diasDiferenca >= 3) {
                System.out.println("Tipo 3");
                Notificacao noti = new Notificacao();
                noti.setNome_da_notificacao(projeto.getNome());
                noti.setTipo_de_notificacao(3);
                noti.setData_de_notificacao(Date.from(DATA_FUTURA_LocalDate.minusDays(3).
                                                                            atStartOfDay(ZoneId.systemDefault()).
                                                                            toInstant()));
                noti.setOrigem(3);
                notificacaoRepository.save(noti);
            }
            if (diasDiferenca >= 1) {
                System.out.println("Tipo 2");
                Notificacao noti = new Notificacao();
                noti.setNome_da_notificacao(projeto.getNome());
                noti.setTipo_de_notificacao(2);
                noti.setData_de_notificacao(Date.from(DATA_FUTURA_LocalDate.minusDays(1).
                                                                            atStartOfDay(ZoneId.systemDefault()).
                                                                            toInstant()));
                noti.setOrigem(3);
                notificacaoRepository.save(noti);
            }
            if (diasDiferenca >= 0) {
                System.out.println("Tipo 1");
                Notificacao noti = new Notificacao();
                noti.setNome_da_notificacao(projeto.getNome());
                noti.setTipo_de_notificacao(1);
                noti.setData_de_notificacao(Date.from(DATA_FUTURA_LocalDate.atStartOfDay(ZoneId.systemDefault()).
                                                                            toInstant()));
                noti.setOrigem(3);
                notificacaoRepository.save(noti);
            }
        
        }
        }

    @Override
    public void deleteByOrigem(int origem) {
        notificacaoRepository.deleteByOrigem(origem);
    }

    @Override
    public List<Notificacao> listarNotificacoes() {
        return notificacaoRepository.findAll();
    }
}

