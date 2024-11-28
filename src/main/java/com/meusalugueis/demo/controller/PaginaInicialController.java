package com.meusalugueis.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.meusalugueis.demo.service.AgendaService;
import com.meusalugueis.demo.service.NotificacaoService;

@Controller
@RequestMapping("/")
public class PaginaInicialController {
    @Autowired
    private NotificacaoService notificacaoService;

    @Autowired
    private AgendaService agendaService;
    
    @GetMapping
    //@ResponseBody
    public ModelAndView index(){
        //logica
        notificacaoService.gerarNotificacoesDeMetas();
        notificacaoService.gerarNotificacoesDeStatusDeProjeto();
        notificacaoService.gerarNotificacoesDePagamentoDeProjeto();
        notificacaoService.gerarNotificacoesDeNegociacoes();
        agendaService.gerarAgenda();
        
        return new ModelAndView("pagina-inicial/index");
    }
}
