package com.meusalugueis.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.meusalugueis.demo.entity.Projeto;
import com.meusalugueis.demo.service.ClienteService;
import com.meusalugueis.demo.service.CorretorService;
import com.meusalugueis.demo.service.ImovelService;
import com.meusalugueis.demo.service.ProjetoService;

@Controller
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ImovelService imovelService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CorretorService corretorService;

    @Autowired
    private ProjetoService projetoService;

    @GetMapping("/novo-projeto")
    public ModelAndView novo() {
        var umProjeto = new Projeto();
        var listaDeClientes = clienteService.getAll();
        var listaDeCorretores = corretorService.getAll();
        var listaDeImoveis = imovelService.getAll();

        HashMap<String, Object> dados = new HashMap<>();
        
        dados.put("umProjeto", umProjeto);
        dados.put("listaDeClientes",listaDeClientes);
        dados.put("listaDeCorretores",listaDeCorretores);
        dados.put("listaDeImoveis",listaDeImoveis);

        return new ModelAndView("projetos/novo-projeto", dados);
    }

    @PostMapping
    public ModelAndView save(Projeto projeto) {
        projetoService.save(projeto);
        return new ModelAndView("redirect:/dashboard");
    }

    @GetMapping("/editar-projeto/{id}")
    public ModelAndView alterar(@PathVariable("id") long id) {
        var umProjeto = projetoService.getById((id));
        var listaDeClientes = clienteService.getAll();
        var listaDeCorretores = corretorService.getAll();
        var listaDeImoveis = imovelService.getAll();

        HashMap<String, Object> dados = new HashMap<>();
        
        dados.put("umProjeto", umProjeto);
        dados.put("listaDeClientes",listaDeClientes);
        dados.put("listaDeCorretores",listaDeCorretores);
        dados.put("listaDeImoveis",listaDeImoveis);

        return new ModelAndView("projetos/editar-projeto", dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        var umProjeto = projetoService.getById(id);
        if(umProjeto != null){
            projetoService.delete(id);
        }
        return new ModelAndView("redirect:/dashboard");
    }
}
