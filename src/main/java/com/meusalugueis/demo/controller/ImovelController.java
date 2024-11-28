package com.meusalugueis.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.meusalugueis.demo.entity.Imovel;
import com.meusalugueis.demo.service.ClienteService;
import com.meusalugueis.demo.service.ImovelService;

@Controller
@RequestMapping("/imoveis")
public class ImovelController {

    @Autowired
    private ImovelService imovelService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ModelAndView index(){
        var listaDeImoveis = imovelService.getAll();
        return new ModelAndView("imoveis/index",
                                "listaDeImoveis",
                                listaDeImoveis);
    }

    @GetMapping("/novo-imovel")
    public ModelAndView novo() {
        var umImovel = new Imovel();
        var listaDeClientes = clienteService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        
        dados.put("umImovel", umImovel);
        dados.put("listaDeClientes",listaDeClientes);

        return new ModelAndView("imoveis/novo-imovel", dados);
    }

    @PostMapping
    public ModelAndView save(Imovel imovel) {
        imovelService.save(imovel);
        return new ModelAndView("redirect:/imoveis");
    }

    @GetMapping("/editar-imovel/{id}")
    public ModelAndView alterar(@PathVariable("id") long id) {
        var umImovel = imovelService.getById(id);
        var listaDeClientes = clienteService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        
        dados.put("umImovel", umImovel);
        dados.put("listaDeClientes",listaDeClientes);

        return new ModelAndView("imoveis/editar-imovel", dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        var umImovel = imovelService.getById(id);
        if(umImovel != null){
            imovelService.delete(id);
        }
        return new ModelAndView("redirect:/imoveis");
    }
}


