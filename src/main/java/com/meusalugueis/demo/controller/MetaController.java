package com.meusalugueis.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.meusalugueis.demo.entity.Meta;
import com.meusalugueis.demo.service.CorretorService;
import com.meusalugueis.demo.service.MetaService;
import com.meusalugueis.demo.service.NotificacaoService;

@Controller
@RequestMapping("/metas")
public class MetaController {

    @Autowired
    private MetaService metaService;

    @Autowired
    private CorretorService corretorService;

    @Autowired NotificacaoService notificacaoService;

    @GetMapping("/nova-meta")
    public ModelAndView novo(){
        HashMap<String, Object> dados = new HashMap<>();
        var umaMeta = new Meta();
        var listaDeCorretores = corretorService.getAll();
        dados.put("umaMeta", umaMeta);
        dados.put("listaDeCorretores",listaDeCorretores);
        return new ModelAndView("metas/nova-meta", dados);
    }

    @PostMapping
    public ModelAndView save(Meta meta) {
        metaService.save(meta);
        return new ModelAndView("redirect:/dashboard");
    }

    @GetMapping("/editar-meta/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){

        HashMap<String, Object> dados = new HashMap<>();
        var umaMeta = metaService.getById(id);
        var listaDeCorretores = corretorService.getAll();
        dados.put("umaMeta", umaMeta);
        dados.put("listaDeCorretores",listaDeCorretores);
        return new ModelAndView("metas/editar-meta", dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        var umaMeta = metaService.getById(id);
        if(umaMeta != null){
            metaService.delete(id);
        }
        return new ModelAndView("redirect:/dashboard");
    }

}
