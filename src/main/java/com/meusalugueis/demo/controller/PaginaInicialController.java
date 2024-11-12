package com.meusalugueis.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class PaginaInicialController {
    
    @GetMapping
    //@ResponseBody
    public ModelAndView index(){
        //logica
        var mensagem = "Bem-vindo ao Meus Aluguéis!";

        return new ModelAndView("pagina-inicial/index", "apelido", mensagem);
    }
}
