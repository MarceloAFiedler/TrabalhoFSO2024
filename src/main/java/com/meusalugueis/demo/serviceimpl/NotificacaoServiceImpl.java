package com.meusalugueis.demo.serviceimpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        notificacaoRepository.deleteByOrigem(1);   
        Date DATA_DE_HOJE = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String APENAS_HOJE = sdf.format(DATA_DE_HOJE);
        
    
        // var listaDeMetas = metaRepository.findByData_limiteLessThanEqual(DATA_DE_HOJE);
        var listaDeMetas = metaRepository.findAll();
            for (Meta meta : listaDeMetas) {
                // Obtém a data base
                Date dataBase = meta.getData_limite();

                if(dataBase == null){
                    continue;
                }

                String APENAS_DATA_LIMITE = sdf.format(dataBase);

                try {
                    Date dataHoje = sdf.parse(APENAS_HOJE);
                    Date dataLimite = sdf.parse(APENAS_DATA_LIMITE);
                    
                    // Verifica se a data da meta é anterior a hoje (não igual)
                    if (dataLimite.before(dataHoje)) {
                        System.out.println("CAIU AQUI APENAS_HOJE ============> " + APENAS_HOJE);
                        System.out.println("CAIU AQUI  APENAS_DATA_LIMITE ============> " + APENAS_DATA_LIMITE);
                        System.out.println("CAIU AQUI  Meta Atual ============> " + meta.getNome());
                        continue;
                    }
                    
                    System.out.println("APENAS_HOJE ============> " + APENAS_HOJE);
                    System.out.println("APENAS_DATA_LIMITE ============> " + APENAS_DATA_LIMITE);
                    System.out.println("Meta Atual ============> " + meta.getNome());
                    
                    // Notificação para o dia da data_limite
                    if (APENAS_DATA_LIMITE.equals(APENAS_HOJE)) {
                        System.out.println("AQUI PORRAAAAAAAAAAAAAAAAAAAA");
                        Notificacao notificacaoHoje = new Notificacao();
                        notificacaoHoje.setNome_da_notificacao(meta.getNome());
                        notificacaoHoje.setTipo_de_notificacao(1);
                        notificacaoHoje.setData_de_notificacao(dataBase);
                        notificacaoHoje.setOrigem(1);
                        notificacaoRepository.save(notificacaoHoje);
                    }

                // Notificação para o dia anterior (1 dia antes)
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(dataBase);
                calendar.add(Calendar.DAY_OF_YEAR, -1);  // Subtrai 1 dia
                Date umDiaAntes = calendar.getTime();
                if (!umDiaAntes.before(DATA_DE_HOJE)) {
                    Notificacao notificacaoUmDiaAntes = new Notificacao();
                    notificacaoUmDiaAntes.setNome_da_notificacao(meta.getNome());
                    notificacaoUmDiaAntes.setTipo_de_notificacao(2);  // Exemplo de tipo
                    notificacaoUmDiaAntes.setData_de_notificacao(umDiaAntes);
                    notificacaoUmDiaAntes.setOrigem(1);
                    notificacaoRepository.save(notificacaoUmDiaAntes);
                }

                // Notificação para 3 dias antes da data_limite
                calendar.setTime(dataBase);
                calendar.add(Calendar.DAY_OF_YEAR, -3);  // Subtrai 3 dias
                Date tresDiasAntes = calendar.getTime();
                if (!tresDiasAntes.before(DATA_DE_HOJE)) {
                    Notificacao notificacaoTresDiasAntes = new Notificacao();
                    notificacaoTresDiasAntes.setNome_da_notificacao(meta.getNome());
                    notificacaoTresDiasAntes.setTipo_de_notificacao(3);  // Exemplo de tipo
                    notificacaoTresDiasAntes.setData_de_notificacao(tresDiasAntes);
                    notificacaoTresDiasAntes.setOrigem(1);
                    notificacaoRepository.save(notificacaoTresDiasAntes);
                }

                // Notificação para 7 dias antes da data_limite
                calendar.setTime(dataBase);
                calendar.add(Calendar.DAY_OF_YEAR, -7);  // Subtrai 7 dias
                Date seteDiasAntes = calendar.getTime();    
                if (!seteDiasAntes.before(DATA_DE_HOJE)) {
                    Notificacao notificacaoSeteDiasAntes = new Notificacao();
                    notificacaoSeteDiasAntes.setNome_da_notificacao(meta.getNome());
                    notificacaoSeteDiasAntes.setTipo_de_notificacao(4);  // Exemplo de tipo
                    notificacaoSeteDiasAntes.setData_de_notificacao(seteDiasAntes);
                    notificacaoSeteDiasAntes.setOrigem(1);
                    notificacaoRepository.save(notificacaoSeteDiasAntes);
                }

                // Notificação para 14 dias antes da data_limite
                calendar.setTime(dataBase);
                calendar.add(Calendar.DAY_OF_YEAR, -14);  // Subtrai 14 dias
                Date quatorzeDiasAntes = calendar.getTime();
                if (!quatorzeDiasAntes.before(DATA_DE_HOJE)) {
                    Notificacao notificacaoQuatorzeDiasAntes = new Notificacao();
                    notificacaoQuatorzeDiasAntes.setNome_da_notificacao(meta.getNome());
                    notificacaoQuatorzeDiasAntes.setTipo_de_notificacao(5);  // Exemplo de tipo
                    notificacaoQuatorzeDiasAntes.setData_de_notificacao(quatorzeDiasAntes);
                    notificacaoQuatorzeDiasAntes.setOrigem(1);
                    notificacaoRepository.save(notificacaoQuatorzeDiasAntes);
                }

                // Notificação para prazos maiores que 14 dias (geral)
                if (dataBase.after(DATA_DE_HOJE)) {
                    Notificacao notificacaoPrazoMaior = new Notificacao();
                    notificacaoPrazoMaior.setNome_da_notificacao(meta.getNome());
                    notificacaoPrazoMaior.setTipo_de_notificacao(6);  // Exemplo de tipo para prazos maiores
                    notificacaoPrazoMaior.setData_de_notificacao(dataBase);
                    notificacaoPrazoMaior.setOrigem(1);
                    notificacaoRepository.save(notificacaoPrazoMaior);
                }
                } catch (ParseException e) {
                    // Trate a exceção apropriadamente
                    e.printStackTrace();
                }
            }
        }

    @Override 
    public void gerarNotificacoesDeNegociacoes() {
            notificacaoRepository.deleteByOrigem(4);   
            Date DATA_DE_HOJE = new Date();
    
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String APENAS_HOJE = sdf.format(DATA_DE_HOJE);
            
        
            // var listaDeMetas = metaRepository.findByData_limiteLessThanEqual(DATA_DE_HOJE);
            var listaDeNegociacoes = negociacaoRepository.findAll();
                for (Negociacao negociacao : listaDeNegociacoes) {
                    // Obtém a data base
                    Date dataBase = negociacao.getData_de_checkpoint_da_fase();
    
                    if(dataBase == null){
                        continue;
                    }
    
                    String APENAS_DATA_LIMITE = sdf.format(dataBase);
    
                    try {
                        Date dataHoje = sdf.parse(APENAS_HOJE);
                        Date dataLimite = sdf.parse(APENAS_DATA_LIMITE);
                        
                        // Verifica se a data da meta é anterior a hoje (não igual)
                        if (dataLimite.before(dataHoje)) {
                            System.out.println("CAIU AQUI APENAS_HOJE ============> " + APENAS_HOJE);
                            System.out.println("CAIU AQUI  APENAS_DATA_LIMITE ============> " + APENAS_DATA_LIMITE);
                            System.out.println("CAIU AQUI  Meta Atual ============> " + negociacao.getNome());
                            continue;
                        }
                        
                        System.out.println("APENAS_HOJE ============> " + APENAS_HOJE);
                        System.out.println("APENAS_DATA_LIMITE ============> " + APENAS_DATA_LIMITE);
                        System.out.println("Meta Atual ============> " + negociacao.getNome());
                        
                        // Notificação para o dia da data_limite
                        if (APENAS_DATA_LIMITE.equals(APENAS_HOJE)) {
                            System.out.println("AQUI PORRAAAAAAAAAAAAAAAAAAAA");
                            Notificacao notificacaoHoje = new Notificacao();
                            notificacaoHoje.setNome_da_notificacao(negociacao.getNome());
                            notificacaoHoje.setTipo_de_notificacao(1);
                            notificacaoHoje.setData_de_notificacao(dataBase);
                            notificacaoHoje.setOrigem(4);
                            notificacaoRepository.save(notificacaoHoje);
                        }
    
                    // Notificação para o dia anterior (1 dia antes)
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(dataBase);
                    calendar.add(Calendar.DAY_OF_YEAR, -1);  // Subtrai 1 dia
                    Date umDiaAntes = calendar.getTime();
                    if (!umDiaAntes.before(DATA_DE_HOJE)) {
                        Notificacao notificacaoUmDiaAntes = new Notificacao();
                        notificacaoUmDiaAntes.setNome_da_notificacao(negociacao.getNome());
                        notificacaoUmDiaAntes.setTipo_de_notificacao(2);  // Exemplo de tipo
                        notificacaoUmDiaAntes.setData_de_notificacao(umDiaAntes);
                        notificacaoUmDiaAntes.setOrigem(4);
                        notificacaoRepository.save(notificacaoUmDiaAntes);
                    }
    
                    // Notificação para 3 dias antes da data_limite
                    calendar.setTime(dataBase);
                    calendar.add(Calendar.DAY_OF_YEAR, -3);  // Subtrai 3 dias
                    Date tresDiasAntes = calendar.getTime();
                    if (!tresDiasAntes.before(DATA_DE_HOJE)) {
                        Notificacao notificacaoTresDiasAntes = new Notificacao();
                        notificacaoTresDiasAntes.setNome_da_notificacao(negociacao.getNome());
                        notificacaoTresDiasAntes.setTipo_de_notificacao(3);  // Exemplo de tipo
                        notificacaoTresDiasAntes.setData_de_notificacao(tresDiasAntes);
                        notificacaoTresDiasAntes.setOrigem(4);
                        notificacaoRepository.save(notificacaoTresDiasAntes);
                    }
    
                    // Notificação para 7 dias antes da data_limite
                    calendar.setTime(dataBase);
                    calendar.add(Calendar.DAY_OF_YEAR, -7);  // Subtrai 7 dias
                    Date seteDiasAntes = calendar.getTime();    
                    if (!seteDiasAntes.before(DATA_DE_HOJE)) {
                        Notificacao notificacaoSeteDiasAntes = new Notificacao();
                        notificacaoSeteDiasAntes.setNome_da_notificacao(negociacao.getNome());
                        notificacaoSeteDiasAntes.setTipo_de_notificacao(4);  // Exemplo de tipo
                        notificacaoSeteDiasAntes.setData_de_notificacao(seteDiasAntes);
                        notificacaoSeteDiasAntes.setOrigem(4);
                        notificacaoRepository.save(notificacaoSeteDiasAntes);
                    }
    
                    // Notificação para 14 dias antes da data_limite
                    calendar.setTime(dataBase);
                    calendar.add(Calendar.DAY_OF_YEAR, -14);  // Subtrai 14 dias
                    Date quatorzeDiasAntes = calendar.getTime();
                    if (!quatorzeDiasAntes.before(DATA_DE_HOJE)) {
                        Notificacao notificacaoQuatorzeDiasAntes = new Notificacao();
                        notificacaoQuatorzeDiasAntes.setNome_da_notificacao(negociacao.getNome());
                        notificacaoQuatorzeDiasAntes.setTipo_de_notificacao(5);  // Exemplo de tipo
                        notificacaoQuatorzeDiasAntes.setData_de_notificacao(quatorzeDiasAntes);
                        notificacaoQuatorzeDiasAntes.setOrigem(4);
                        notificacaoRepository.save(notificacaoQuatorzeDiasAntes);
                    }
    
                    // Notificação para prazos maiores que 14 dias (geral)
                    if (dataBase.after(DATA_DE_HOJE)) {
                        Notificacao notificacaoPrazoMaior = new Notificacao();
                        notificacaoPrazoMaior.setNome_da_notificacao(negociacao.getNome());
                        notificacaoPrazoMaior.setTipo_de_notificacao(6);  // Exemplo de tipo para prazos maiores
                        notificacaoPrazoMaior.setData_de_notificacao(dataBase);
                        notificacaoPrazoMaior.setOrigem(4);
                        notificacaoRepository.save(notificacaoPrazoMaior);
                    }
                    } catch (ParseException e) {
                        // Trate a exceção apropriadamente
                        e.printStackTrace();
                    }
                }
            }

    @Override
    public void gerarNotificacoesDeStatusDeProjeto() {
        notificacaoRepository.deleteByOrigem(2);   
        Date DATA_DE_HOJE = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String APENAS_HOJE = sdf.format(DATA_DE_HOJE);
        
    
        // var listaDeMetas = metaRepository.findByData_limiteLessThanEqual(DATA_DE_HOJE);
        var listaDeProjetos = projetoRepository.findAll();
            for (Projeto projeto : listaDeProjetos) {
                // Obtém a data base
                Date dataBase = projeto.getData_de_checkpoint_status_do_projeto();

                if(dataBase == null){
                    continue;
                }

                String APENAS_DATA_LIMITE = sdf.format(dataBase);

                try {
                    Date dataHoje = sdf.parse(APENAS_HOJE);
                    Date dataLimite = sdf.parse(APENAS_DATA_LIMITE);
                    
                    // Verifica se a data da meta é anterior a hoje (não igual)
                    if (dataLimite.before(dataHoje)) {
                        System.out.println("CAIU AQUI APENAS_HOJE ============> " + APENAS_HOJE);
                        System.out.println("CAIU AQUI  APENAS_DATA_LIMITE ============> " + APENAS_DATA_LIMITE);
                        System.out.println("CAIU AQUI  Meta Atual ============> " + projeto.getNome());
                        continue;
                    }
                    
                    System.out.println("APENAS_HOJE ============> " + APENAS_HOJE);
                    System.out.println("APENAS_DATA_LIMITE ============> " + APENAS_DATA_LIMITE);
                    System.out.println("Meta Atual ============> " + projeto.getNome());
                    
                    // Notificação para o dia da data_limite
                    if (APENAS_DATA_LIMITE.equals(APENAS_HOJE)) {
                        System.out.println("AQUI PORRAAAAAAAAAAAAAAAAAAAA");
                        Notificacao notificacaoHoje = new Notificacao();
                        notificacaoHoje.setNome_da_notificacao(projeto.getNome());
                        notificacaoHoje.setTipo_de_notificacao(1);
                        notificacaoHoje.setData_de_notificacao(dataBase);
                        notificacaoHoje.setOrigem(1);
                        notificacaoRepository.save(notificacaoHoje);
                    }

                // Notificação para o dia anterior (1 dia antes)
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(dataBase);
                calendar.add(Calendar.DAY_OF_YEAR, -1);  // Subtrai 1 dia
                Date umDiaAntes = calendar.getTime();
                if (!umDiaAntes.before(DATA_DE_HOJE)) {
                    Notificacao notificacaoUmDiaAntes = new Notificacao();
                    notificacaoUmDiaAntes.setNome_da_notificacao(projeto.getNome());
                    notificacaoUmDiaAntes.setTipo_de_notificacao(2);  // Exemplo de tipo
                    notificacaoUmDiaAntes.setData_de_notificacao(umDiaAntes);
                    notificacaoUmDiaAntes.setOrigem(1);
                    notificacaoRepository.save(notificacaoUmDiaAntes);
                }

                // Notificação para 3 dias antes da data_limite
                calendar.setTime(dataBase);
                calendar.add(Calendar.DAY_OF_YEAR, -3);  // Subtrai 3 dias
                Date tresDiasAntes = calendar.getTime();
                if (!tresDiasAntes.before(DATA_DE_HOJE)) {
                    Notificacao notificacaoTresDiasAntes = new Notificacao();
                    notificacaoTresDiasAntes.setNome_da_notificacao(projeto.getNome());
                    notificacaoTresDiasAntes.setTipo_de_notificacao(3);  // Exemplo de tipo
                    notificacaoTresDiasAntes.setData_de_notificacao(tresDiasAntes);
                    notificacaoTresDiasAntes.setOrigem(1);
                    notificacaoRepository.save(notificacaoTresDiasAntes);
                }

                // Notificação para 7 dias antes da data_limite
                calendar.setTime(dataBase);
                calendar.add(Calendar.DAY_OF_YEAR, -7);  // Subtrai 7 dias
                Date seteDiasAntes = calendar.getTime();    
                if (!seteDiasAntes.before(DATA_DE_HOJE)) {
                    Notificacao notificacaoSeteDiasAntes = new Notificacao();
                    notificacaoSeteDiasAntes.setNome_da_notificacao(projeto.getNome());
                    notificacaoSeteDiasAntes.setTipo_de_notificacao(4);  // Exemplo de tipo
                    notificacaoSeteDiasAntes.setData_de_notificacao(seteDiasAntes);
                    notificacaoSeteDiasAntes.setOrigem(1);
                    notificacaoRepository.save(notificacaoSeteDiasAntes);
                }

                // Notificação para 14 dias antes da data_limite
                calendar.setTime(dataBase);
                calendar.add(Calendar.DAY_OF_YEAR, -14);  // Subtrai 14 dias
                Date quatorzeDiasAntes = calendar.getTime();
                if (!quatorzeDiasAntes.before(DATA_DE_HOJE)) {
                    Notificacao notificacaoQuatorzeDiasAntes = new Notificacao();
                    notificacaoQuatorzeDiasAntes.setNome_da_notificacao(projeto.getNome());
                    notificacaoQuatorzeDiasAntes.setTipo_de_notificacao(5);  // Exemplo de tipo
                    notificacaoQuatorzeDiasAntes.setData_de_notificacao(quatorzeDiasAntes);
                    notificacaoQuatorzeDiasAntes.setOrigem(1);
                    notificacaoRepository.save(notificacaoQuatorzeDiasAntes);
                }

                // Notificação para prazos maiores que 14 dias (geral)
                if (dataBase.after(DATA_DE_HOJE)) {
                    Notificacao notificacaoPrazoMaior = new Notificacao();
                    notificacaoPrazoMaior.setNome_da_notificacao(projeto.getNome());
                    notificacaoPrazoMaior.setTipo_de_notificacao(6);  // Exemplo de tipo para prazos maiores
                    notificacaoPrazoMaior.setData_de_notificacao(dataBase);
                    notificacaoPrazoMaior.setOrigem(1);
                    notificacaoRepository.save(notificacaoPrazoMaior);
                }
                } catch (ParseException e) {
                    // Trate a exceção apropriadamente
                    e.printStackTrace();
                }
            }
        }

    @Override
    public void gerarNotificacoesDePagamentoDeProjeto() {
        notificacaoRepository.deleteByOrigem(3);   
        Date DATA_DE_HOJE = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String APENAS_HOJE = sdf.format(DATA_DE_HOJE);
        
    
        // var listaDeMetas = metaRepository.findByData_limiteLessThanEqual(DATA_DE_HOJE);
        var listaDeProjetos = projetoRepository.findAll();
            for (Projeto projeto : listaDeProjetos) {
                // Obtém a data base
                Date dataBase = projeto.getData_de_checkpoint_status_do_pagamento();

                if(dataBase == null){
                    continue;
                }

                String APENAS_DATA_LIMITE = sdf.format(dataBase);

                try {
                    Date dataHoje = sdf.parse(APENAS_HOJE);
                    Date dataLimite = sdf.parse(APENAS_DATA_LIMITE);
                    
                    // Verifica se a data da meta é anterior a hoje (não igual)
                    if (dataLimite.before(dataHoje)) {
                        System.out.println("CAIU AQUI APENAS_HOJE ============> " + APENAS_HOJE);
                        System.out.println("CAIU AQUI  APENAS_DATA_LIMITE ============> " + APENAS_DATA_LIMITE);
                        System.out.println("CAIU AQUI  Meta Atual ============> " + projeto.getNome());
                        continue;
                    }
                    
                    System.out.println("APENAS_HOJE ============> " + APENAS_HOJE);
                    System.out.println("APENAS_DATA_LIMITE ============> " + APENAS_DATA_LIMITE);
                    System.out.println("Meta Atual ============> " + projeto.getNome());
                    
                    // Notificação para o dia da data_limite
                    if (APENAS_DATA_LIMITE.equals(APENAS_HOJE)) {
                        System.out.println("AQUI PORRAAAAAAAAAAAAAAAAAAAA");
                        Notificacao notificacaoHoje = new Notificacao();
                        notificacaoHoje.setNome_da_notificacao(projeto.getNome());
                        notificacaoHoje.setTipo_de_notificacao(1);
                        notificacaoHoje.setData_de_notificacao(dataBase);
                        notificacaoHoje.setOrigem(1);
                        notificacaoRepository.save(notificacaoHoje);
                    }

                // Notificação para o dia anterior (1 dia antes)
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(dataBase);
                calendar.add(Calendar.DAY_OF_YEAR, -1);  // Subtrai 1 dia
                Date umDiaAntes = calendar.getTime();
                if (!umDiaAntes.before(DATA_DE_HOJE)) {
                    Notificacao notificacaoUmDiaAntes = new Notificacao();
                    notificacaoUmDiaAntes.setNome_da_notificacao(projeto.getNome());
                    notificacaoUmDiaAntes.setTipo_de_notificacao(2);  // Exemplo de tipo
                    notificacaoUmDiaAntes.setData_de_notificacao(umDiaAntes);
                    notificacaoUmDiaAntes.setOrigem(1);
                    notificacaoRepository.save(notificacaoUmDiaAntes);
                }

                // Notificação para 3 dias antes da data_limite
                calendar.setTime(dataBase);
                calendar.add(Calendar.DAY_OF_YEAR, -3);  // Subtrai 3 dias
                Date tresDiasAntes = calendar.getTime();
                if (!tresDiasAntes.before(DATA_DE_HOJE)) {
                    Notificacao notificacaoTresDiasAntes = new Notificacao();
                    notificacaoTresDiasAntes.setNome_da_notificacao(projeto.getNome());
                    notificacaoTresDiasAntes.setTipo_de_notificacao(3);  // Exemplo de tipo
                    notificacaoTresDiasAntes.setData_de_notificacao(tresDiasAntes);
                    notificacaoTresDiasAntes.setOrigem(1);
                    notificacaoRepository.save(notificacaoTresDiasAntes);
                }

                // Notificação para 7 dias antes da data_limite
                calendar.setTime(dataBase);
                calendar.add(Calendar.DAY_OF_YEAR, -7);  // Subtrai 7 dias
                Date seteDiasAntes = calendar.getTime();    
                if (!seteDiasAntes.before(DATA_DE_HOJE)) {
                    Notificacao notificacaoSeteDiasAntes = new Notificacao();
                    notificacaoSeteDiasAntes.setNome_da_notificacao(projeto.getNome());
                    notificacaoSeteDiasAntes.setTipo_de_notificacao(4);  // Exemplo de tipo
                    notificacaoSeteDiasAntes.setData_de_notificacao(seteDiasAntes);
                    notificacaoSeteDiasAntes.setOrigem(1);
                    notificacaoRepository.save(notificacaoSeteDiasAntes);
                }

                // Notificação para 14 dias antes da data_limite
                calendar.setTime(dataBase);
                calendar.add(Calendar.DAY_OF_YEAR, -14);  // Subtrai 14 dias
                Date quatorzeDiasAntes = calendar.getTime();
                if (!quatorzeDiasAntes.before(DATA_DE_HOJE)) {
                    Notificacao notificacaoQuatorzeDiasAntes = new Notificacao();
                    notificacaoQuatorzeDiasAntes.setNome_da_notificacao(projeto.getNome());
                    notificacaoQuatorzeDiasAntes.setTipo_de_notificacao(5);  // Exemplo de tipo
                    notificacaoQuatorzeDiasAntes.setData_de_notificacao(quatorzeDiasAntes);
                    notificacaoQuatorzeDiasAntes.setOrigem(1);
                    notificacaoRepository.save(notificacaoQuatorzeDiasAntes);
                }

                // Notificação para prazos maiores que 14 dias (geral)
                if (dataBase.after(DATA_DE_HOJE)) {
                    Notificacao notificacaoPrazoMaior = new Notificacao();
                    notificacaoPrazoMaior.setNome_da_notificacao(projeto.getNome());
                    notificacaoPrazoMaior.setTipo_de_notificacao(6);  // Exemplo de tipo para prazos maiores
                    notificacaoPrazoMaior.setData_de_notificacao(dataBase);
                    notificacaoPrazoMaior.setOrigem(1);
                    notificacaoRepository.save(notificacaoPrazoMaior);
                }
                } catch (ParseException e) {
                    // Trate a exceção apropriadamente
                    e.printStackTrace();
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

