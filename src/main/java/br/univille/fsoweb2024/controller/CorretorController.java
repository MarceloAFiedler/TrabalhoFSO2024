package br.univille.fsoweb2024.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.fsoweb2024.repository.CorretorRepository;
import br.univille.fsoweb2024.service.CorretorService;

@Controller
@RequestMapping("/corretores")
public class CorretorController {
    
    @Autowired
    private CorretorService service;

    @GetMapping
    public ModelAndView index(){
        //chamar banco de dados e fazer um select * from tabelas
        var listaCorretores = service.getAll();
        //montar a tela html com dados do banco
        return new ModelAndView("corretor/index","listaCorretores",listaCorretores);

    }
}
