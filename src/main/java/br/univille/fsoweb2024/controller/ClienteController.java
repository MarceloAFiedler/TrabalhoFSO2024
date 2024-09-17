package br.univille.fsoweb2024.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.fsoweb2024.repository.ClienteRepository;


@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public ModelAndView index(){
        // chamar banco
        // fazer SELECT * FROM
        var listaDeClientes = repository.findAll();
        // montar tela com os dados
        return new ModelAndView("cliente/index",
                                "listaDeClientes",
                                listaDeClientes);

    }
}
