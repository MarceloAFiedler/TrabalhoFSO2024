package com.meusalugueis.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.meusalugueis.demo.service.ProjetoService;
import com.meusalugueis.demo.service.MetaService;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private MetaService metaService;

    @GetMapping
    public ModelAndView dashboard() {

        var listaDeProjetos = projetoService.getAll();
        var listaDeMetas = metaService.getAll();

        ModelAndView modelAndView = new ModelAndView("dashboard/index");
        modelAndView.addObject("listaDeProjetos", listaDeProjetos);
        modelAndView.addObject("listaDeMetas", listaDeMetas);

        return modelAndView;
    }
}
