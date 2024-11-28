package com.meusalugueis.demo.controller;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
    public ModelAndView save(@RequestParam("foto") MultipartFile foto, Corretor corretor)throws IOException {
        corretorService.save(corretor);
        corretor.salvarFoto(foto);
        return new ModelAndView("redirect:/corretores");
    }

    // @GetMapping("/editar-corretor/{id}")
    // public ModelAndView alterar(@PathVariable("id") long id) {
    //     var umCorretor = corretorService.getById(id);
    //     ModelAndView modelAndView = new ModelAndView("corretores/editar-corretor", "umCorretor", umCorretor);
    //     return modelAndView;
    // }

    @GetMapping("/editar-corretor/{id}")
    public ModelAndView editarCorretorForm(@PathVariable("id") long id) {
        var umCorretor = corretorService.getById(id);
        ModelAndView modelAndView = new ModelAndView("corretores/editar-corretor", "umCorretor", umCorretor);
        return modelAndView;
    }

    @PostMapping("/editar-corretor/{id}")
    public ModelAndView editarCorretor(@RequestParam("foto") MultipartFile foto, @PathVariable("id") long id) throws IOException {
        var umCorretor = corretorService.getById(id);

        // Salvaa a nova foto
        umCorretor.salvarFoto(foto);
        corretorService.save(umCorretor); // Salva as mudanças no banco, se necessário

        ModelAndView modelAndView = new ModelAndView("redirect:/corretores");
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