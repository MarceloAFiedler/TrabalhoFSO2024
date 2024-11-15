package com.meusalugueis.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.meusalugueis.demo.service.NotificacaoService;

@Controller
@RequestMapping("/")
public class PaginaInicialController {
    @Autowired
    private NotificacaoService notificacaoService;
    
    @GetMapping
    //@ResponseBody
    public ModelAndView index(){
        //logica
        notificacaoService.gerarNotificacoesDeMetas();
        var mensagem = notificacaoService.listarNotificacoes();
        
        return new ModelAndView("pagina-inicial/index", "apelido", mensagem);
    }
}
