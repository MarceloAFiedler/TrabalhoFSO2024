package com.meusalugueis.demo.serviceimpl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meusalugueis.demo.entity.Meta;
import com.meusalugueis.demo.entity.Notificacao;
import com.meusalugueis.demo.entity.Projeto;
import com.meusalugueis.demo.repository.MetaRepository;
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

    @Override
    public void gerarNotificacoesDeMetas() {
        notificacaoRepository.deleteByOrigem(1);   
        Date DATA_DE_HOJE = new Date();
        // var listaDeMetas = metaRepository.findByData_limiteLessThanEqual(DATA_DE_HOJE);
        var listaDeMetas = metaRepository.findAll();
            for (Meta meta : listaDeMetas) {
                // Obtém a data base (data_limite) da meta
                Date dataBase = meta.getData_limite();
                
                // Verifica se a data da meta é válida, se não for, não gera notificações
                if (dataBase == null || dataBase.before(DATA_DE_HOJE)) {
                    continue;  // Pula a meta se a data for inválida ou anterior à data de hoje
                }
                
                // Cria notificações com base na lógica que você descreveu
                // Notificação para o dia da data_limite
                if (dataBase.equals(DATA_DE_HOJE)) {
                    Notificacao notificacaoHoje = new Notificacao();
                    notificacaoHoje.setNome_da_notificacao(meta.getNome());
                    notificacaoHoje.setTipo_de_notificacao(1); // Exemplo de tipo
                    notificacaoHoje.setData_de_notificacao(dataBase); // A data da notificação é a mesma da data_limite
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
            }
        }



    @Override
    public List<Notificacao> listarNotificacoes() {
        return notificacaoRepository.findAll();
    }

    @Override
    public void gerarNotificacoesDeStatusDeProjeto() {
        notificacaoRepository.deleteByOrigem(2);    
        Date DATA_DE_HOJE = new Date();
        // var listaDeMetas = metaRepository.findByData_limiteLessThanEqual(DATA_DE_HOJE);
        var listaDeProjetos = projetoRepository.findAll();
            for (Projeto projeto : listaDeProjetos) {
                // Obtém a data base (data_limite) da meta
                Date dataBase = projeto.getData_de_checkpoint_status_do_projeto();
                
                // Verifica se a data da meta é válida, se não for, não gera notificações
                if (dataBase == null || dataBase.before(DATA_DE_HOJE)) {
                    continue;  // Pula a meta se a data for inválida ou anterior à data de hoje
                }
                
                // Cria notificações com base na lógica que você descreveu
                // Notificação para o dia da data_limite
                if (dataBase.equals(DATA_DE_HOJE)) {
                    Notificacao notificacaoHoje = new Notificacao();
                    notificacaoHoje.setNome_da_notificacao(projeto.getNome());
                    notificacaoHoje.setTipo_de_notificacao(1); // Exemplo de tipo
                    notificacaoHoje.setData_de_notificacao(dataBase); // A data da notificação é a mesma da data_limite
                    notificacaoHoje.setOrigem(2);
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
                    notificacaoUmDiaAntes.setOrigem(2);
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
                    notificacaoTresDiasAntes.setOrigem(2);
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
                    notificacaoSeteDiasAntes.setOrigem(2);
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
                    notificacaoQuatorzeDiasAntes.setOrigem(2);
                    notificacaoRepository.save(notificacaoQuatorzeDiasAntes);
                }

                // Notificação para prazos maiores que 14 dias (geral)
                if (dataBase.after(DATA_DE_HOJE)) {
                    Notificacao notificacaoPrazoMaior = new Notificacao();
                    notificacaoPrazoMaior.setNome_da_notificacao(projeto.getNome());
                    notificacaoPrazoMaior.setTipo_de_notificacao(6);  // Exemplo de tipo para prazos maiores
                    notificacaoPrazoMaior.setData_de_notificacao(dataBase);
                    notificacaoPrazoMaior.setOrigem(2);
                    notificacaoRepository.save(notificacaoPrazoMaior);
                }
            }
        }

    @Override
    public void gerarNotificacoesDePagamentoDeProjeto() {
        notificacaoRepository.deleteByOrigem(3);   
        Date DATA_DE_HOJE = new Date();
        // var listaDeMetas = metaRepository.findByData_limiteLessThanEqual(DATA_DE_HOJE);
        var listaDeProjetos = projetoRepository.findAll();
            for (Projeto projeto : listaDeProjetos) {
                // Obtém a data base (data_limite) da meta
                Date dataBase = projeto.getData_de_checkpoint_status_do_pagamento();
                
                // Verifica se a data da meta é válida, se não for, não gera notificações
                if (dataBase == null || dataBase.before(DATA_DE_HOJE)) {
                    continue;  // Pula a meta se a data for inválida ou anterior à data de hoje
                }
                
                // Cria notificações com base na lógica que você descreveu
                // Notificação para o dia da data_limite
                if (dataBase.equals(DATA_DE_HOJE)) {
                    Notificacao notificacaoHoje = new Notificacao();
                    notificacaoHoje.setNome_da_notificacao(projeto.getNome());
                    notificacaoHoje.setTipo_de_notificacao(1); // Exemplo de tipo
                    notificacaoHoje.setData_de_notificacao(dataBase); // A data da notificação é a mesma da data_limite
                    notificacaoHoje.setOrigem(3);
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
                    notificacaoUmDiaAntes.setOrigem(3);
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
                    notificacaoTresDiasAntes.setOrigem(3);
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
                    notificacaoSeteDiasAntes.setOrigem(3);
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
                    notificacaoQuatorzeDiasAntes.setOrigem(3);
                    notificacaoRepository.save(notificacaoQuatorzeDiasAntes);
                }

                // Notificação para prazos maiores que 14 dias (geral)
                if (dataBase.after(DATA_DE_HOJE)) {
                    Notificacao notificacaoPrazoMaior = new Notificacao();
                    notificacaoPrazoMaior.setNome_da_notificacao(projeto.getNome());
                    notificacaoPrazoMaior.setTipo_de_notificacao(6);  // Exemplo de tipo para prazos maiores
                    notificacaoPrazoMaior.setData_de_notificacao(dataBase);
                    notificacaoPrazoMaior.setOrigem(3);
                    notificacaoRepository.save(notificacaoPrazoMaior);
                }
            }
        }

        @Override
        public void deleteByOrigem(int origem) {
        // Deleta todas as notificações com origem = 2
            notificacaoRepository.deleteByOrigem(origem);
        }

}

