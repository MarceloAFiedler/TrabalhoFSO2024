package com.meusalugueis.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.meusalugueis.demo.entity.Corretor;
import com.meusalugueis.demo.service.CorretorService;

@Controller
@RequestMapping("/corretores")
public class CorretorController {
    @Autowired
    private CorretorService corretorService;

    @GetMapping
    public ModelAndView index(){
        var listaDeCorretores = corretorService.getAll();
        return new ModelAndView("corretores/index", "listaDeCorretores", listaDeCorretores);
    }

    @GetMapping("/novo-corretor")
    public ModelAndView novo() {
        var umCorretor = new Corretor();

        HashMap<String, Object> dados = new HashMap<>();
        
        dados.put("umCorretor", umCorretor);

        return new ModelAndView("corretores/novo-corretor", dados);
    }

    @PostMapping
    public ModelAndView save(Corretor corretor) {
        corretorService.save(corretor);
        return new ModelAndView("redirect:/corretores");
    }

    @GetMapping("/editar-corretor/{id}")
    public ModelAndView alterar(@PathVariable("id") long id) {
        var umCorretor = corretorService.getById(id);
        ModelAndView modelAndView = new ModelAndView("corretores/editar-corretor", "umCorretor", umCorretor);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        var umCorretor = corretorService.getById(id);
        if(umCorretor != null){
            corretorService.delete(id);
        }
        return new ModelAndView("redirect:/corretores");
    }

}