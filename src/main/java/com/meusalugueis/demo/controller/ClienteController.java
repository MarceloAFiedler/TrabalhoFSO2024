package com.meusalugueis.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.meusalugueis.demo.entity.Cliente;
import com.meusalugueis.demo.service.ClienteService;
import com.meusalugueis.demo.service.CorretorService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private CorretorService corretorService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ModelAndView index(){
        var listaDeClientes = clienteService.getAll();
        return new ModelAndView("clientes/index",
                                "listaDeClientes",
                                listaDeClientes);
    }

    @GetMapping("/novo-cliente")
    public ModelAndView novo() {
        var umCliente = new Cliente();
        var listaDeCorretores = corretorService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        
        dados.put("umCliente", umCliente);
        dados.put("listaDeCorretores",listaDeCorretores);

        return new ModelAndView("clientes/novo-cliente", dados);
    }

    @PostMapping
    public ModelAndView save(Cliente cliente) {
        clienteService.save(cliente);
        return new ModelAndView("redirect:/clientes");
    }

    @GetMapping("/editar-cliente/{id}")
    public ModelAndView alterar(@PathVariable("id") long id) {
        var umCliente = clienteService.getById(id);
        var listaDeCorretores = corretorService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        
        dados.put("umCliente", umCliente);
        dados.put("listaDeCorretores",listaDeCorretores);

        return new ModelAndView("clientes/editar-cliente", dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        var umCliente = clienteService.getById(id);
        if(umCliente != null){
            clienteService.delete(id);
        }
        return new ModelAndView("redirect:/clientes");
    }
}
