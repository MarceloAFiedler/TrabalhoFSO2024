package com.meusalugueis.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.meusalugueis.demo.entity.Meta;
import com.meusalugueis.demo.service.MetaService;

@Controller
@RequestMapping("/metas")
public class MetaController {

    @Autowired
    private MetaService metaService;

    @GetMapping("/nova-meta")
    public ModelAndView novo(){
        var umaMeta = new Meta();
        return new ModelAndView("metas/nova-meta", "umaMeta", umaMeta);
    }

    @PostMapping
    public ModelAndView save(Meta meta) {
        metaService.save(meta);
        return new ModelAndView("redirect:/dashboard");
    }

    @GetMapping("/editar-meta/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var umaMeta = metaService.getById(id);
        return new ModelAndView("metas/editar-meta", "umaMeta", umaMeta);
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
