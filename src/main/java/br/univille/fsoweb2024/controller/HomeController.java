package br.univille.fsoweb2024.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
    
    @GetMapping
    //@ResponseBody
    public ModelAndView index(){
        //logica
        var mensagem = "eu nao acredito";

        return new ModelAndView("home/index", "apelido", mensagem);
    }
}
