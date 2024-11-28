package com.meusalugueis.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.meusalugueis.demo.service.AgendaService;

@Controller
@RequestMapping("/agenda")
public class AgendaController {
    @Autowired
    private AgendaService agendaService;
    
    @GetMapping
    public ModelAndView index(){
        agendaService.gerarAgenda();
        var listaDeAgendas = agendaService.getAll();
        
        return new ModelAndView("agenda/index", "listaDeAgendas", listaDeAgendas);
    }
}
