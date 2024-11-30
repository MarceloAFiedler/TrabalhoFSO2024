package com.meusalugueis.demo.controller;

import java.util.HashMap;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.meusalugueis.demo.entity.Cliente;
import com.meusalugueis.demo.entity.Imovel;
import com.meusalugueis.demo.service.ClienteService;
import com.meusalugueis.demo.service.SalvarArquivosService;
import com.meusalugueis.demo.service.ImovelService;

@Controller
@RequestMapping("/imoveis")
public class ImovelController {

    @Autowired
    private ImovelService imovelService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private SalvarArquivosService salvarArquivoService;

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
    public ModelAndView save(Imovel imovel, @RequestParam("file") MultipartFile file) {
        if(file.getSize() != 0){
            String caminho = salvarArquivoService.save_imovel(file);
            imovel.setFoto(caminho);
        }
        imovelService.save(imovel);
        return new ModelAndView("redirect:/imoveis");
    }

    @GetMapping(value = "/image/{id}")
    public @ResponseBody byte[] getImage(@PathVariable("id") Imovel imovel){
        try{
            File file = new File(imovel.getFoto());
            byte[] bytes = new byte[(int) file.length()];
            try(DataInputStream dis = new DataInputStream(new FileInputStream(file));){
                dis.readFully(bytes);
            }
            return bytes;
        }catch (Exception e){
            return new byte[0];
        }
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


