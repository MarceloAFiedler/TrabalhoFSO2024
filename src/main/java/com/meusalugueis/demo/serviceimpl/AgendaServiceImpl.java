package com.meusalugueis.demo.serviceimpl;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meusalugueis.demo.entity.Agenda;
import com.meusalugueis.demo.entity.Projeto;
import com.meusalugueis.demo.entity.Meta;
import com.meusalugueis.demo.entity.Negociacao;
import com.meusalugueis.demo.repository.AgendaRepository;
import com.meusalugueis.demo.repository.MetaRepository;
import com.meusalugueis.demo.repository.NegociacaoRepository;
import com.meusalugueis.demo.repository.ProjetoRepository;
import com.meusalugueis.demo.service.AgendaService;

@Service
public class AgendaServiceImpl implements AgendaService{

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private NegociacaoRepository negociacaoRepository;

    @Autowired
    private MetaRepository metaRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Override
    public List<Agenda> getAll() {
        return agendaRepository.findAll();
    }

    @Override
    public Agenda save(Agenda agenda) {
       return agendaRepository.save(agenda);
    }

    @Override
    public Agenda delete(long id) {
        var retorno = agendaRepository.findById(id);
        if(retorno.isPresent()){
            agendaRepository.deleteById(id);
            return retorno.get();
        }
        return null;
    }

    @Override
    public Agenda getById(long id) {
        var retorno = agendaRepository.findById(id);
        if(retorno.isPresent()){
            agendaRepository.findById(id);
            return retorno.get();
        }
        return null;
    }

    public List<Agenda> gerarAgenda(){

            deleteAll();

            LocalDate hoje = LocalDate.now();

            DayOfWeek diaDaSemana = hoje.getDayOfWeek();

            LocalDate inicioDaSemana = hoje.minusDays(diaDaSemana.getValue() - DayOfWeek.MONDAY.getValue());

            List<LocalDate> diasDaSemana = new ArrayList<>();

            for (int i = 0; i < 7; i++) {
                diasDaSemana.add(inicioDaSemana.plusDays(i));
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            diasDaSemana.forEach(data -> System.out.println(data.format(formatter)));

            diasDaSemana.forEach(data -> System.out.println(data.getClass().getName()));

            var listaDeMetas = metaRepository.findAll();
            for(Meta meta : listaDeMetas){
                var dataBase = meta.getData_limite();
                String dataParaComparar = sdf.format(dataBase);
                var dataParaSetar = meta.getData_limite();
                System.out.println("DATA DA META = " + meta.getData_limite().getClass().getName());
                
                if(dataParaComparar.equals(diasDaSemana.get(0).format(formatter))){
                    System.out.println("CAIU AQUI dds = " + dataParaComparar + " dsemana = " + diasDaSemana.get(0));
                    Agenda agenda = new Agenda();
                    agenda.setData_do_compromisso(dataParaSetar);
                    agenda.setDia_da_semana(1);
                    agenda.setTipo(1);
                    agenda.setDescricao(meta.getNome());
                    agendaRepository.save(agenda);

                } else if(dataParaComparar.equals(diasDaSemana.get(1).format(formatter))){
                    System.out.println("CAIU AQUI dds = " + dataParaComparar + " dsemana = " + diasDaSemana.get(1));
                    Agenda agenda = new Agenda();
                    agenda.setData_do_compromisso(dataParaSetar);
                    agenda.setDia_da_semana(2);
                    agenda.setTipo(1);
                    agenda.setDescricao(meta.getNome());
                    agendaRepository.save(agenda);
                }else if(dataParaComparar.equals(diasDaSemana.get(2).format(formatter))){
                    System.out.println("CAIU AQUI dds = " + dataParaComparar + " dsemana = " + diasDaSemana.get(2));
                    Agenda agenda = new Agenda();
                    agenda.setData_do_compromisso(dataParaSetar);
                    agenda.setDia_da_semana(3);
                    agenda.setTipo(1);
                    agenda.setDescricao(meta.getNome());
                    agendaRepository.save(agenda);
                }else if(dataParaComparar.equals(diasDaSemana.get(3).format(formatter))){
                    System.out.println("CAIU AQUI dds = " + dataParaComparar + " dsemana = " + diasDaSemana.get(3));
                    Agenda agenda = new Agenda();
                    agenda.setData_do_compromisso(dataParaSetar);
                    agenda.setDia_da_semana(4);
                    agenda.setTipo(1);
                    agenda.setDescricao(meta.getNome());
                    agendaRepository.save(agenda);
                }else if(dataParaComparar.equals(diasDaSemana.get(4).format(formatter))){
                    System.out.println("CAIU AQUI dds = " + dataParaComparar + " dsemana = " + diasDaSemana.get(4));
                    Agenda agenda = new Agenda();
                    agenda.setData_do_compromisso(dataParaSetar);
                    agenda.setDia_da_semana(5);
                    agenda.setTipo(1);
                    agenda.setDescricao(meta.getNome());
                    agendaRepository.save(agenda);
                }else if(dataParaComparar.equals(diasDaSemana.get(5).format(formatter))){
                    System.out.println("CAIU AQUI dds = " + dataParaComparar + " dsemana = " + diasDaSemana.get(5));
                    Agenda agenda = new Agenda();
                    agenda.setData_do_compromisso(dataParaSetar);
                    agenda.setDia_da_semana(6);
                    agenda.setTipo(1);
                    agenda.setDescricao(meta.getNome());
                    agendaRepository.save(agenda);
                }else if(dataParaComparar.equals(diasDaSemana.get(6).format(formatter))){
                    System.out.println("CAIU AQUI dds = " + dataParaComparar + " dsemana = " + diasDaSemana.get(6));
                    Agenda agenda = new Agenda();
                    agenda.setData_do_compromisso(dataParaSetar);
                    agenda.setDia_da_semana(7);
                    agenda.setTipo(1);
                    agenda.setDescricao(meta.getNome());
                    agendaRepository.save(agenda);
                }
            }
            
            var listaDeNegociacoes = negociacaoRepository.findAll();
            for(Negociacao negociacao : listaDeNegociacoes){
                var dataBase = negociacao.getData_de_checkpoint_da_fase();
                String dataParaComparar = sdf.format(dataBase);
                var dataParaSetar = negociacao.getData_de_checkpoint_da_fase();
                
                if(dataParaComparar.equals(diasDaSemana.get(0).format(formatter))){
                    Agenda agenda = new Agenda();
                    agenda.setData_do_compromisso(dataParaSetar);
                    agenda.setDia_da_semana(1);
                    agenda.setTipo(2);
                    agenda.setDescricao(negociacao.getNome());
                    agendaRepository.save(agenda);

                } else if(dataParaComparar.equals(diasDaSemana.get(1).format(formatter))){
                    Agenda agenda = new Agenda();
                    agenda.setData_do_compromisso(dataParaSetar);
                    agenda.setDia_da_semana(2);
                    agenda.setTipo(2);
                    agenda.setDescricao(negociacao.getNome());
                    agendaRepository.save(agenda);
                }else if(dataParaComparar.equals(diasDaSemana.get(2).format(formatter))){
                    Agenda agenda = new Agenda();
                    agenda.setData_do_compromisso(dataParaSetar);
                    agenda.setDia_da_semana(3);
                    agenda.setTipo(2);
                    agenda.setDescricao(negociacao.getNome());
                    agendaRepository.save(agenda);
                }else if(dataParaComparar.equals(diasDaSemana.get(3).format(formatter))){
                    Agenda agenda = new Agenda();
                    agenda.setData_do_compromisso(dataParaSetar);
                    agenda.setDia_da_semana(4);
                    agenda.setTipo(2);
                    agenda.setDescricao(negociacao.getNome());
                    agendaRepository.save(agenda);
                }else if(dataParaComparar.equals(diasDaSemana.get(4).format(formatter))){
                    Agenda agenda = new Agenda();
                    agenda.setData_do_compromisso(dataParaSetar);
                    agenda.setDia_da_semana(5);
                    agenda.setTipo(2);
                    agenda.setDescricao(negociacao.getNome());
                    agendaRepository.save(agenda);
                }else if(dataParaComparar.equals(diasDaSemana.get(5).format(formatter))){
                    Agenda agenda = new Agenda();
                    agenda.setData_do_compromisso(dataParaSetar);
                    agenda.setDia_da_semana(6);
                    agenda.setTipo(2);
                    agenda.setDescricao(negociacao.getNome());
                    agendaRepository.save(agenda);
                }else if(dataParaComparar.equals(diasDaSemana.get(6).format(formatter))){
                    Agenda agenda = new Agenda();
                    agenda.setData_do_compromisso(dataParaSetar);
                    agenda.setDia_da_semana(7);
                    agenda.setTipo(2);
                    agenda.setDescricao(negociacao.getNome());
                    agendaRepository.save(agenda);
                }
            }

            var listaDeProjetos_StatusDoProjeto = projetoRepository.findAll();
            for(Projeto projeto : listaDeProjetos_StatusDoProjeto){
                var dataBase = projeto.getData_de_checkpoint_status_do_projeto();
                String dataParaComparar = sdf.format(dataBase);
                var dataParaSetar = projeto.getData_de_checkpoint_status_do_projeto();
                
                if(dataParaComparar.equals(diasDaSemana.get(0).format(formatter))){
                    Agenda agenda = new Agenda();
                    agenda.setData_do_compromisso(dataParaSetar);
                    agenda.setDia_da_semana(1);
                    agenda.setTipo(3);
                    agenda.setDescricao(projeto.getNome());
                    agendaRepository.save(agenda);

                } else if(dataParaComparar.equals(diasDaSemana.get(1).format(formatter))){
                    Agenda agenda = new Agenda();
                    agenda.setData_do_compromisso(dataParaSetar);
                    agenda.setDia_da_semana(2);
                    agenda.setTipo(3);
                    agenda.setDescricao(projeto.getNome());
                    agendaRepository.save(agenda);
                }else if(dataParaComparar.equals(diasDaSemana.get(2).format(formatter))){
                    Agenda agenda = new Agenda();
                    agenda.setData_do_compromisso(dataParaSetar);
                    agenda.setDia_da_semana(3);
                    agenda.setTipo(3);
                    agenda.setDescricao(projeto.getNome());
                    agendaRepository.save(agenda);
                }else if(dataParaComparar.equals(diasDaSemana.get(3).format(formatter))){
                    Agenda agenda = new Agenda();
                    agenda.setData_do_compromisso(dataParaSetar);
                    agenda.setDia_da_semana(4);
                    agenda.setTipo(3);
                    agenda.setDescricao(projeto.getNome());
                    agendaRepository.save(agenda);
                }else if(dataParaComparar.equals(diasDaSemana.get(4).format(formatter))){
                    Agenda agenda = new Agenda();
                    agenda.setData_do_compromisso(dataParaSetar);
                    agenda.setDia_da_semana(5);
                    agenda.setTipo(3);
                    agenda.setDescricao(projeto.getNome());
                    agendaRepository.save(agenda);
                }else if(dataParaComparar.equals(diasDaSemana.get(5).format(formatter))){
                    Agenda agenda = new Agenda();
                    agenda.setData_do_compromisso(dataParaSetar);
                    agenda.setDia_da_semana(6);
                    agenda.setTipo(3);
                    agenda.setDescricao(projeto.getNome());
                    agendaRepository.save(agenda);
                }else if(dataParaComparar.equals(diasDaSemana.get(6).format(formatter))){
                    Agenda agenda = new Agenda();
                    agenda.setData_do_compromisso(dataParaSetar);
                    agenda.setDia_da_semana(7);
                    agenda.setTipo(3);
                    agenda.setDescricao(projeto.getNome());
                    agendaRepository.save(agenda);
                }
            }

            var listaDeProjetos_StatusDoPagamento = projetoRepository.findAll();
            for(Projeto projeto : listaDeProjetos_StatusDoPagamento){
                var dataBase = projeto.getData_de_checkpoint_status_do_pagamento();
                String dataParaComparar = sdf.format(dataBase);
                var dataParaSetar = projeto.getData_de_checkpoint_status_do_pagamento();
                
                if(dataParaComparar.equals(diasDaSemana.get(0).format(formatter))){
                    Agenda agenda = new Agenda();
                    agenda.setData_do_compromisso(dataParaSetar);
                    agenda.setDia_da_semana(1);
                    agenda.setTipo(4);
                    agenda.setDescricao(projeto.getNome());
                    agendaRepository.save(agenda);

                } else if(dataParaComparar.equals(diasDaSemana.get(1).format(formatter))){
                    Agenda agenda = new Agenda();
                    agenda.setData_do_compromisso(dataParaSetar);
                    agenda.setDia_da_semana(2);
                    agenda.setTipo(4);
                    agenda.setDescricao(projeto.getNome());
                    agendaRepository.save(agenda);
                }else if(dataParaComparar.equals(diasDaSemana.get(2).format(formatter))){
                    Agenda agenda = new Agenda();
                    agenda.setData_do_compromisso(dataParaSetar);
                    agenda.setDia_da_semana(3);
                    agenda.setTipo(4);
                    agenda.setDescricao(projeto.getNome());
                    agendaRepository.save(agenda);
                }else if(dataParaComparar.equals(diasDaSemana.get(3).format(formatter))){
                    Agenda agenda = new Agenda();
                    agenda.setData_do_compromisso(dataParaSetar);
                    agenda.setDia_da_semana(4);
                    agenda.setTipo(4);
                    agenda.setDescricao(projeto.getNome());
                    agendaRepository.save(agenda);
                }else if(dataParaComparar.equals(diasDaSemana.get(4).format(formatter))){
                    Agenda agenda = new Agenda();
                    agenda.setData_do_compromisso(dataParaSetar);
                    agenda.setDia_da_semana(5);
                    agenda.setTipo(4);
                    agenda.setDescricao(projeto.getNome());
                    agendaRepository.save(agenda);
                }else if(dataParaComparar.equals(diasDaSemana.get(5).format(formatter))){
                    Agenda agenda = new Agenda();
                    agenda.setData_do_compromisso(dataParaSetar);
                    agenda.setDia_da_semana(6);
                    agenda.setTipo(4);
                    agenda.setDescricao(projeto.getNome());
                    agendaRepository.save(agenda);
                }else if(dataParaComparar.equals(diasDaSemana.get(6).format(formatter))){
                    Agenda agenda = new Agenda();
                    agenda.setData_do_compromisso(dataParaSetar);
                    agenda.setDia_da_semana(7);
                    agenda.setTipo(4);
                    agenda.setDescricao(projeto.getNome());
                    agendaRepository.save(agenda);
                }
            }
    return agendaRepository.findAll();
}

    @Override
    public void deleteAll(){
        agendaRepository.deleteAll();
    }

}