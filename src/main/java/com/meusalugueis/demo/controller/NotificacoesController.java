package com.meusalugueis.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.meusalugueis.demo.service.NotificacaoService;

@Controller
@RequestMapping("/notificacoes")
public class NotificacoesController {
    @Autowired
    private NotificacaoService notificacaoService;
    
    @GetMapping
    public ModelAndView index(){
        //logica
        var listaDeNotificacoes = notificacaoService.listarNotificacoes();
        
        return new ModelAndView("notificacoes/index", "listaDeNotificacoes", listaDeNotificacoes);
    }
}
