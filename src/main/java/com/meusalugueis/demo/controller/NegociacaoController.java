package com.meusalugueis.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.meusalugueis.demo.entity.Negociacao;
import com.meusalugueis.demo.service.ClienteService;
import com.meusalugueis.demo.service.CorretorService;
import com.meusalugueis.demo.service.ImovelService;
import com.meusalugueis.demo.service.NegociacaoService;
import com.meusalugueis.demo.service.ProjetoService;

@Controller
@RequestMapping("/negociacoes")
public class NegociacaoController {
    
    @Autowired
    private ImovelService imovelService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CorretorService corretorService;

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private NegociacaoService negociacaoService;

    @GetMapping
    public ModelAndView index(){
        //chamar o banco de dados e fazer um select * from tabela
        var listaDeNegociacoes = negociacaoService.getAll();
        //montar a tela com os dados banco
        return new ModelAndView("negociacoes/index",
                                "listaDeNegociacoes",
                                listaDeNegociacoes);
    }

    @GetMapping("/nova-negociacao")
    public ModelAndView novo() {
        var umaNegociacao = new Negociacao();
        var listaDeClientes = clienteService.getAll();
        var listaDeProjetos = projetoService.getAll();
        var listaDeCorretores = corretorService.getAll();
        var listaDeImoveis = imovelService.getAll();

        HashMap<String, Object> dados = new HashMap<>();
        
        dados.put("umaNegociacao", umaNegociacao);
        dados.put("listaDeClientes",listaDeClientes);
        dados.put("listaDeClientes",listaDeProjetos);
        dados.put("listaDeCorretores",listaDeCorretores);
        dados.put("listaDeImoveis",listaDeImoveis);

        return new ModelAndView("negociacoes/nova-negociacao", dados);
    }

    @PostMapping
    public ModelAndView save(Negociacao negociacao) {
        negociacaoService.save(negociacao);
        return new ModelAndView("redirect:/negociacoes");
    }

    @GetMapping("/editar-negociacao/{id}")
    public ModelAndView alterar(@PathVariable("id") long id) {
        var umaNegociacao = negociacaoService.getById(id);
        var listaDeClientes = clienteService.getAll();
        var listaDeProjetos = projetoService.getAll();
        var listaDeCorretores = corretorService.getAll();
        var listaDeImoveis = imovelService.getAll();

        HashMap<String, Object> dados = new HashMap<>();
        
        dados.put("umaNegociacao", umaNegociacao);
        dados.put("listaDeClientes",listaDeClientes);
        dados.put("listaDeClientes",listaDeProjetos);
        dados.put("listaDeCorretores",listaDeCorretores);
        dados.put("listaDeImoveis",listaDeImoveis);

        return new ModelAndView("negociacoes/editar-negociacao", dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        var umaNegociacao = negociacaoService.getById(id);
        if(umaNegociacao != null){
            negociacaoService.delete(id);
        }
        return new ModelAndView("redirect:/negociacoes");
    }
}
