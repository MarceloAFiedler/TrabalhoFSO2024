package com.meusalugueis.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meusalugueis.demo.entity.Agenda;

@Service
public interface AgendaService {
    
    List<Agenda> getAll();

    List<Agenda> gerarAgenda();

    void deleteAll();

    Agenda save(Agenda agenda);

    Agenda delete(long id);

    Agenda getById(long id);
}
