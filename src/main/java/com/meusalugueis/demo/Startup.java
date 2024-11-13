package com.meusalugueis.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.meusalugueis.demo.entity.Cliente;
import com.meusalugueis.demo.entity.Corretor;
import com.meusalugueis.demo.service.ClienteService;
import com.meusalugueis.demo.service.CorretorService;

@Component
public class Startup {
    @Autowired
    private CorretorService corretorService;

    @Autowired
    private ClienteService clienteService;


    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event){
       // Corretor 1 - Barba Branca

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try{
            var corretor1 = new Corretor();
            corretor1.setId(2);
            corretor1.setNome("Edward Newgate");
            corretor1.setSobrenome("Barba Branca");
            corretor1.setCreci("2222.2222-SC");
            corretor1.setRg("111.111-11");
            corretor1.setCpf("222.222.222-22");
            corretor1.setComissao(5.0);
            corretor1.setData_de_nascimento(sdf.parse("11/02/2002"));
            corretor1.setEmail("barbabranca@onepiece.com");
            corretorService.save(corretor1);
    
            // Corretor 2 - Garp
            var corretor2 = new Corretor();
            corretor2.setId(3);
            corretor2.setNome("Monkey D.");
            corretor2.setSobrenome("Garp");
            corretor2.setCreci("3333.3333-SC");
            corretor2.setRg("222.222-22");
            corretor2.setCpf("333.333.333-33");
            corretor2.setComissao(4.0);
            corretor2.setData_de_nascimento(sdf.parse("02/07/1930"));
            corretor2.setEmail("garp@onepiece.com");
            corretorService.save(corretor2);
    
            // Corretor 3 - Gol D. Roger
            var corretor3 = new Corretor();
            corretor3.setId(4);
            corretor3.setNome("Gol D.");
            corretor3.setSobrenome("Roger");
            corretor3.setCreci("4444.4444-SC");
            corretor3.setRg("333.333-33");
            corretor3.setCpf("444.444.444-44");
            corretor3.setComissao(6.0);
            corretor3.setData_de_nascimento(sdf.parse("10/10/1930"));
            corretor3.setEmail("goldo.roger@onepiece.com");
            corretorService.save(corretor3);
    
            // Cliente 1 - Luffy
            var cliente1 = new Cliente();
            cliente1.setNome("Monkey D.");
            cliente1.setSobrenome("Luffy");
            cliente1.setTipo("Pessoa Física");
            cliente1.setRg("123456789");
            cliente1.setCpf("123.456.789-00");
            cliente1.setEmail("monkeydluffy@onepiece.com");
            cliente1.setTelefone("47 999999001");
            cliente1.setData_de_nascimento(sdf.parse("05/05/1999"));
            cliente1.setCorretor_responsavel(corretorService.getById(1));
            clienteService.save(cliente1);
    
            // Cliente 2 - Zoro
            var cliente2 = new Cliente();
            cliente2.setNome("Roronoa");
            cliente2.setSobrenome("Zoro");
            cliente2.setTipo("Pessoa Física");
            cliente2.setRg("234567890");
            cliente2.setCpf("234.567.890-11");
            cliente2.setEmail("roronoazoro@onepiece.com");
            cliente2.setTelefone("47 999999002");
            cliente2.setData_de_nascimento(sdf.parse("11/11/1996"));
            cliente2.setCorretor_responsavel(corretorService.getById(2));
            clienteService.save(cliente2);
    
            // Cliente 3 - Nami
            var cliente3 = new Cliente();
            cliente3.setNome("Nami");
            cliente3.setSobrenome("Nami");
            cliente3.setTipo("Pessoa Física");
            cliente3.setRg("345678901");
            cliente3.setCpf("345.678.901-22");
            cliente3.setEmail("nami@onepiece.com");
            cliente3.setTelefone("47 999999003");
            cliente3.setData_de_nascimento(sdf.parse("03/07/1996"));
            cliente3.setCorretor_responsavel(corretorService.getById(1));
            clienteService.save(cliente3);
    
            // Cliente 4 - Usopp
            var cliente4 = new Cliente();
            cliente4.setNome("Usopp");
            cliente4.setSobrenome("Usopp");
            cliente4.setTipo("Pessoa Jurídica");
            cliente4.setRg("456789012");
            cliente4.setCpf("456.789.012-33");
            cliente4.setEmail("usopp@onepiece.com");
            cliente4.setTelefone("47 999999004");
            cliente4.setData_de_nascimento(sdf.parse("01/04/1997"));
            cliente4.setCorretor_responsavel(corretorService.getById(3));
            clienteService.save(cliente4);
    
            // Cliente 5 - Sanji
            var cliente5 = new Cliente();
            cliente5.setNome("Vinsmoke");
            cliente5.setSobrenome("Sanji");
            cliente5.setTipo("Pessoa Jurídica");
            cliente5.setRg("567890123");
            cliente5.setCpf("567.890.123-44");
            cliente5.setEmail("vinsmokesanji@onepiece.com");
            cliente5.setTelefone("47 999999005");
            cliente5.setData_de_nascimento(sdf.parse("02/03/1995"));
            cliente5.setCorretor_responsavel(corretorService.getById(2));
            clienteService.save(cliente5);
    
            // Cliente 6 - Chopper
            var cliente6 = new Cliente();
            cliente6.setNome("Tony Tony");
            cliente6.setSobrenome("Chopper");
            cliente6.setTipo("Pessoa Jurídica");
            cliente6.setRg("678901234");
            cliente6.setCpf("678.901.234-55");
            cliente6.setEmail("tonytonychopper@onepiece.com");
            cliente6.setTelefone("47 999999006");
            cliente6.setData_de_nascimento(sdf.parse("24/12/2000"));
            cliente6.setCorretor_responsavel(corretorService.getById(2));
            clienteService.save(cliente6);
    
            // Cliente 7 - Nico Robin
            var cliente7 = new Cliente();
            cliente7.setNome("Nico");
            cliente7.setSobrenome("Robin");
            cliente7.setTipo("Pessoa Jurídica");
            cliente7.setRg("789012345");
            cliente7.setCpf("789.012.345-66");
            cliente7.setEmail("nicorobin@onepiece.com");
            cliente7.setTelefone("47 999999007");
            cliente7.setData_de_nascimento(sdf.parse("06/02/1997"));
            cliente7.setCorretor_responsavel(corretorService.getById(3));
            clienteService.save(cliente7);
    
            // Cliente 8 - Franky
            var cliente8 = new Cliente();
            cliente8.setNome("Cutty");
            cliente8.setSobrenome("Flamingo Franky");
            cliente8.setTipo("Pessoa Física");
            cliente8.setRg("890123456");
            cliente8.setCpf("890.123.456-77");
            cliente8.setEmail("franky@onepiece.com");
            cliente8.setTelefone("47 999999008");
            cliente8.setData_de_nascimento(sdf.parse("09/03/1995"));
            cliente8.setCorretor_responsavel(corretorService.getById(1));
            clienteService.save(cliente8);
    
            // Cliente 9 - Brook
            var cliente9 = new Cliente();
            cliente9.setNome("Brook");
            cliente9.setSobrenome("Brook");
            cliente9.setTipo("Pirata");
            cliente9.setRg("901234567");
            cliente9.setCpf("901.234.567-88");
            cliente9.setEmail("brook@onepiece.com");
            cliente9.setTelefone("47 999999009");
            cliente9.setData_de_nascimento(sdf.parse("03/04/1993"));
            cliente9.setCorretor_responsavel(corretorService.getById(2));
            clienteService.save(cliente9);
    
            // Cliente 10 - Jinbe
            var cliente10 = new Cliente();
            cliente10.setNome("Jinbe");
            cliente10.setSobrenome("Jinbe");
            cliente10.setTipo("Pirata");
            cliente10.setRg("012345678");
            cliente10.setCpf("012.345.678-99");
            cliente10.setEmail("jinbe@onepiece.com");
            cliente10.setTelefone("47 999999010");
            cliente10.setData_de_nascimento(sdf.parse("05/05/1990"));
            cliente10.setCorretor_responsavel(corretorService.getById(3));
            clienteService.save(cliente10);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        

    }   
}
