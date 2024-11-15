package com.meusalugueis.demo;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.meusalugueis.demo.entity.Cliente;
import com.meusalugueis.demo.entity.Corretor;
import com.meusalugueis.demo.entity.Imovel;
import com.meusalugueis.demo.entity.Meta;
import com.meusalugueis.demo.entity.Projeto;
import com.meusalugueis.demo.service.ClienteService;
import com.meusalugueis.demo.service.CorretorService;
import com.meusalugueis.demo.service.ImovelService;
import com.meusalugueis.demo.service.MetaService;
import com.meusalugueis.demo.service.ProjetoService;

@Component
public class Startup {
    @Autowired
    private CorretorService corretorService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ImovelService imovelService;

    @Autowired
    private MetaService metaService;

    @Autowired
    private ProjetoService projetoService;


    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event){
       // Corretor 1 - Barba Branca

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try{
            // Corretor 1 - Barba Branca
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
            cliente1.setFuncao("1");
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
            cliente2.setFuncao("1");
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
            cliente3.setFuncao("1");
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
            cliente4.setFuncao("2");
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
            cliente5.setFuncao("2");
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
            cliente6.setFuncao("1");
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
            cliente7.setFuncao("1");
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
            cliente8.setFuncao("2");
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
            cliente9.setFuncao("3");
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
            cliente10.setFuncao("1");
            clienteService.save(cliente10);

            // cadastrando Imoveis

            Imovel imovel1 = new Imovel();
            imovel1.setCodigo("#001");
            imovel1.setNome("Casa de Praia");
            imovel1.setCidade("Rio de Janeiro");
            imovel1.setEstado("RJ");
            imovel1.setRua("Avenida Atlântica");
            imovel1.setNumero("123");
            imovel1.setCep("12345-678");
            imovel1.setPonto_de_referencia("Perto da praia");
            imovel1.setAndares(2);
            imovel1.setQuantidade_de_quartos(4);
            imovel1.setQuantidade_de_suites(2);
            imovel1.setQuantidade_de_cozinhas(1);
            imovel1.setQuantidade_de_banheiros(3);
            imovel1.setQuantidade_de_salas(2);
            imovel1.setQuantidade_de_garagens(1);
            imovel1.setValor(new BigDecimal("1200000.00"));
            imovel1.setStatus("1"); // Disponível
            imovel1.setTipo("1"); // Casa
            imovel1.setVenda_ou_aluguel("1"); // Venda
            imovel1.setInformacoes_extras("Imóvel de luxo com vista para o mar.");
            imovel1.setCliente_proprietario(cliente1);
    
            imovelService.save(imovel1);
    
            Imovel imovel2 = new Imovel();
            imovel2.setCodigo("#002");
            imovel2.setNome("Apartamento no Centro");
            imovel2.setCidade("São Paulo");
            imovel2.setEstado("SP");
            imovel2.setRua("Rua dos Três Irmãos");
            imovel2.setNumero("456");
            imovel2.setCep("98765-432");
            imovel2.setPonto_de_referencia("Perto do metrô");
            imovel2.setAndares(1);
            imovel2.setQuantidade_de_quartos(2);
            imovel2.setQuantidade_de_suites(1);
            imovel2.setQuantidade_de_cozinhas(1);
            imovel2.setQuantidade_de_banheiros(2);
            imovel2.setQuantidade_de_salas(1);
            imovel2.setQuantidade_de_garagens(1);
            imovel2.setValor(new BigDecimal("500000.00"));
            imovel2.setStatus("2"); // Reservado
            imovel2.setTipo("2"); // Apartamento
            imovel2.setVenda_ou_aluguel("2"); // Aluguel
            imovel2.setInformacoes_extras("Apartamento moderno, reformado.");
            imovel2.setCliente_proprietario(cliente2);
    
            imovelService.save(imovel2);

            Imovel imovel3 = new Imovel();
            imovel3.setCodigo("#003");
            imovel3.setNome("Apartamento no Centro");
            imovel3.setCidade("Joinville");
            imovel3.setEstado("SC");
            imovel3.setRua("Rua dos 2 Irmãos");
            imovel3.setNumero("900");
            imovel3.setCep("98885-432");
            imovel3.setPonto_de_referencia("Perto do centro");
            imovel3.setAndares(1);
            imovel3.setQuantidade_de_quartos(2);
            imovel3.setQuantidade_de_suites(1);
            imovel3.setQuantidade_de_cozinhas(1);
            imovel3.setQuantidade_de_banheiros(2);
            imovel3.setQuantidade_de_salas(1);
            imovel3.setQuantidade_de_garagens(1);
            imovel3.setValor(new BigDecimal("500000.00"));
            imovel3.setStatus("2"); // Reservado
            imovel3.setTipo("2"); // Apartamento
            imovel3.setVenda_ou_aluguel("2"); // Aluguel
            imovel3.setInformacoes_extras("Apartamento moderno, reformado.");
            imovel3.setCliente_proprietario(cliente3);
    
            imovelService.save(imovel3);

            Imovel imovel4 = new Imovel();
            imovel4.setCodigo("#004");
            imovel4.setNome("Casa com piscina");
            imovel4.setCidade("Florianópolis");
            imovel4.setEstado("SC");
            imovel4.setRua("Avenida das Palmeiras");
            imovel4.setNumero("1500");
            imovel4.setCep("88045-999");
            imovel4.setPonto_de_referencia("Próxima à praia");
            imovel4.setAndares(2);
            imovel4.setQuantidade_de_quartos(3);
            imovel4.setQuantidade_de_suites(2);
            imovel4.setQuantidade_de_cozinhas(1);
            imovel4.setQuantidade_de_banheiros(3);
            imovel4.setQuantidade_de_salas(2);
            imovel4.setQuantidade_de_garagens(2);
            imovel4.setValor(new BigDecimal("1200000.00"));
            imovel4.setStatus("1"); // Disponível
            imovel4.setTipo("1"); // Casa
            imovel4.setVenda_ou_aluguel("1"); // Venda
            imovel4.setInformacoes_extras("Casa ampla com piscina e área gourmet.");
            imovel4.setCliente_proprietario(cliente4);

            imovelService.save(imovel4);

            Imovel imovel5 = new Imovel();
            imovel5.setCodigo("#005");
            imovel5.setNome("Apartamento de luxo");
            imovel5.setCidade("Curitiba");
            imovel5.setEstado("PR");
            imovel5.setRua("Rua XV de Novembro");
            imovel5.setNumero("120");
            imovel5.setCep("80230-050");
            imovel5.setPonto_de_referencia("Centro, perto de restaurantes");
            imovel5.setAndares(1);
            imovel5.setQuantidade_de_quartos(4);
            imovel5.setQuantidade_de_suites(3);
            imovel5.setQuantidade_de_cozinhas(1);
            imovel5.setQuantidade_de_banheiros(4);
            imovel5.setQuantidade_de_salas(2);
            imovel5.setQuantidade_de_garagens(3);
            imovel5.setValor(new BigDecimal("3500000.00"));
            imovel5.setStatus("1"); // Disponível
            imovel5.setTipo("2"); // Apartamento
            imovel5.setVenda_ou_aluguel("1"); // Venda
            imovel5.setInformacoes_extras("Apartamento de luxo com vista panorâmica.");
            imovel5.setCliente_proprietario(cliente5);

            imovelService.save(imovel5);

            Imovel imovel6 = new Imovel();
            imovel6.setCodigo("#006");
            imovel6.setNome("Chácara em área rural");
            imovel6.setCidade("São José");
            imovel6.setEstado("SC");
            imovel6.setRua("Estrada dos Tropeiros");
            imovel6.setNumero("232");
            imovel6.setCep("88102-530");
            imovel6.setPonto_de_referencia("Próxima ao Centro da cidade");
            imovel6.setAndares(1);
            imovel6.setQuantidade_de_quartos(3);
            imovel6.setQuantidade_de_suites(1);
            imovel6.setQuantidade_de_cozinhas(1);
            imovel6.setQuantidade_de_banheiros(2);
            imovel6.setQuantidade_de_salas(1);
            imovel6.setQuantidade_de_garagens(2);
            imovel6.setValor(new BigDecimal("800000.00"));
            imovel6.setStatus("1"); // Disponível
            imovel6.setTipo("1"); // Casa
            imovel6.setVenda_ou_aluguel("1"); // Venda
            imovel6.setInformacoes_extras("Chácara com grande área de terreno e piscina.");
            imovel6.setCliente_proprietario(cliente6);

            imovelService.save(imovel6);

            // Criando os Projetos
            Projeto projeto1 = new Projeto();
            projeto1.setCodigo("#001");
            projeto1.setNome("Casa nova para fulano");
            projeto1.setData_de_inicio(sdf.parse("11/11/2024"));
            projeto1.setData_de_termino(sdf.parse("18/11/2024"));
            projeto1.setData_de_checkpoint_status_do_projeto(sdf.parse("13/11/2024"));
            projeto1.setData_de_checkpoint_status_do_pagamento(sdf.parse("13/11/2024"));
            projeto1.setNumero_do_contrato("2024.206-00");
            projeto1.setStatus_do_projeto(1);
            projeto1.setStatus_do_pagamento(1);
            projeto1.setCorretor_do_projeto(corretorService.getById(1));  // Corretor com ID 1
            projeto1.setCliente_do_projeto(clienteService.getById(1));    // Cliente com ID 1
            projeto1.setImovel_do_projeto(imovelService.getById(4));      // Imóvel com ID 4
            projeto1.setInformacoes_extras("Projeto seed 1");
            projetoService.save(projeto1);
            
            Projeto projeto2 = new Projeto();
            projeto2.setCodigo("#002");
            projeto2.setNome("Apartamento do José");
            projeto2.setData_de_inicio(sdf.parse("01/12/2024"));
            projeto2.setData_de_termino(sdf.parse("15/12/2024"));
            projeto2.setData_de_checkpoint_status_do_projeto(sdf.parse("05/12/2024"));
            projeto2.setData_de_checkpoint_status_do_pagamento(sdf.parse("05/12/2024"));
            projeto2.setNumero_do_contrato("2024.207-00");
            projeto2.setStatus_do_projeto(1);
            projeto2.setStatus_do_pagamento(1);
            projeto2.setCorretor_do_projeto(corretorService.getById(2));  // Corretor com ID 2
            projeto2.setCliente_do_projeto(clienteService.getById(2));    // Cliente com ID 2
            projeto2.setImovel_do_projeto(imovelService.getById(5));      // Imóvel com ID 5
            projeto2.setInformacoes_extras("Projeto seed 2");
            projetoService.save(projeto2);
            
            Projeto projeto3 = new Projeto();
            projeto3.setCodigo("#003");
            projeto3.setNome("Chácara do Manuel");
            projeto3.setData_de_inicio(sdf.parse("10/01/2025"));
            projeto3.setData_de_termino(sdf.parse("20/01/2025"));
            projeto3.setData_de_checkpoint_status_do_projeto(sdf.parse("15/01/2025"));
            projeto3.setData_de_checkpoint_status_do_pagamento(sdf.parse("15/01/2025"));
            projeto3.setNumero_do_contrato("2025.208-00");
            projeto3.setStatus_do_projeto(1);
            projeto3.setStatus_do_pagamento(1);
            projeto3.setCorretor_do_projeto(corretorService.getById(3));  // Corretor com ID 3
            projeto3.setCliente_do_projeto(clienteService.getById(3));    // Cliente com ID 3
            projeto3.setImovel_do_projeto(imovelService.getById(6));      // Imóvel com ID 6
            projeto3.setInformacoes_extras("Projeto seed 3");
            projetoService.save(projeto3);
            
            Projeto projeto4 = new Projeto();
            projeto4.setCodigo("#004");
            projeto4.setNome("Loja Comercial");
            projeto4.setData_de_inicio(sdf.parse("05/02/2025"));
            projeto4.setData_de_termino(sdf.parse("15/02/2025"));
            projeto4.setData_de_checkpoint_status_do_projeto(sdf.parse("10/02/2025"));
            projeto4.setData_de_checkpoint_status_do_pagamento(sdf.parse("10/02/2025"));
            projeto4.setNumero_do_contrato("2025.209-00");
            projeto4.setStatus_do_projeto(1);
            projeto4.setStatus_do_pagamento(1);
            projeto4.setCorretor_do_projeto(corretorService.getById(3));  // Corretor com ID 4
            projeto4.setCliente_do_projeto(clienteService.getById(4));    // Cliente com ID 4
            projeto4.setImovel_do_projeto(imovelService.getById(1));      // Imóvel com ID 7
            projeto4.setInformacoes_extras("Projeto seed 4");
            projetoService.save(projeto4);
            
            Projeto projeto5 = new Projeto();
            projeto5.setCodigo("#005");
            projeto5.setNome("Casa de Praia");
            projeto5.setData_de_inicio(sdf.parse("15/03/2025"));
            projeto5.setData_de_termino(sdf.parse("30/03/2025"));
            projeto5.setData_de_checkpoint_status_do_projeto(sdf.parse("20/03/2025"));
            projeto5.setData_de_checkpoint_status_do_pagamento(sdf.parse("20/03/2025"));
            projeto5.setNumero_do_contrato("2025.210-00");
            projeto5.setStatus_do_projeto(1);
            projeto5.setStatus_do_pagamento(1);
            projeto5.setCorretor_do_projeto(corretorService.getById(3));  // Corretor com ID 5
            projeto5.setCliente_do_projeto(clienteService.getById(5));    // Cliente com ID 5
            projeto5.setImovel_do_projeto(imovelService.getById(1));      // Imóvel com ID 8
            projeto5.setInformacoes_extras("Projeto seed 5");
            projetoService.save(projeto5);
            
            Projeto projeto6 = new Projeto();
            projeto6.setCodigo("#006");
            projeto6.setNome("Apartamento de Luxo");
            projeto6.setData_de_inicio(sdf.parse("01/04/2025"));
            projeto6.setData_de_termino(sdf.parse("10/04/2025"));
            projeto6.setData_de_checkpoint_status_do_projeto(sdf.parse("05/04/2025"));
            projeto6.setData_de_checkpoint_status_do_pagamento(sdf.parse("05/04/2025"));
            projeto6.setNumero_do_contrato("2025.211-00");
            projeto6.setStatus_do_projeto(1);
            projeto6.setStatus_do_pagamento(1);
            projeto6.setCorretor_do_projeto(corretorService.getById(3));  // Corretor com ID 6
            projeto6.setCliente_do_projeto(clienteService.getById(6));    // Cliente com ID 6
            projeto6.setImovel_do_projeto(imovelService.getById(4));      // Imóvel com ID 9
            projeto6.setInformacoes_extras("Projeto seed 6");
            projetoService.save(projeto6);
            
            Projeto projeto7 = new Projeto();
            projeto7.setCodigo("#007");
            projeto7.setNome("Chácara de Recreio");
            projeto7.setData_de_inicio(sdf.parse("10/05/2025"));
            projeto7.setData_de_termino(sdf.parse("25/05/2025"));
            projeto7.setData_de_checkpoint_status_do_projeto(sdf.parse("15/05/2025"));
            projeto7.setData_de_checkpoint_status_do_pagamento(sdf.parse("15/05/2025"));
            projeto7.setNumero_do_contrato("2025.212-00");
            projeto7.setStatus_do_projeto(1);
            projeto7.setStatus_do_pagamento(1);
            projeto7.setCorretor_do_projeto(corretorService.getById(3));  // Corretor com ID 7
            projeto7.setCliente_do_projeto(clienteService.getById(7));    // Cliente com ID 7
            projeto7.setImovel_do_projeto(imovelService.getById(5));     // Imóvel com ID 10
            projeto7.setInformacoes_extras("Projeto seed 7");
            projetoService.save(projeto7);
            
            Projeto projeto8 = new Projeto();
            projeto8.setCodigo("#008");
            projeto8.setNome("Casa para Renovação");
            projeto8.setData_de_inicio(sdf.parse("01/06/2025"));
            projeto8.setData_de_termino(sdf.parse("15/06/2025"));
            projeto8.setData_de_checkpoint_status_do_projeto(sdf.parse("05/06/2025"));
            projeto8.setData_de_checkpoint_status_do_pagamento(sdf.parse("05/06/2025"));
            projeto8.setNumero_do_contrato("2025.213-00");
            projeto8.setStatus_do_projeto(1);
            projeto8.setStatus_do_pagamento(1);
            projeto8.setCorretor_do_projeto(corretorService.getById(3));  // Corretor com ID 8
            projeto8.setCliente_do_projeto(clienteService.getById(8));    // Cliente com ID 8
            projeto8.setImovel_do_projeto(imovelService.getById(3));     // Imóvel com ID 11
            projeto8.setInformacoes_extras("Projeto seed 8");
            projetoService.save(projeto8);
            
            Projeto projeto9 = new Projeto();
            projeto9.setCodigo("#009");
            projeto9.setNome("Sítio para Venda");
            projeto9.setData_de_inicio(sdf.parse("20/07/2025"));
            projeto9.setData_de_termino(sdf.parse("30/07/2025"));
            projeto9.setData_de_checkpoint_status_do_projeto(sdf.parse("25/07/2025"));
            projeto9.setData_de_checkpoint_status_do_pagamento(sdf.parse("25/07/2025"));
            projeto9.setNumero_do_contrato("2025.214-00");
            projeto9.setStatus_do_projeto(1);
            projeto9.setStatus_do_pagamento(1);
            projeto9.setCorretor_do_projeto(corretorService.getById(2));  // Corretor com ID 9
            projeto9.setCliente_do_projeto(clienteService.getById(9));    // Cliente com ID 9
            projeto9.setImovel_do_projeto(imovelService.getById(3));     // Imóvel com ID 12
            projeto9.setInformacoes_extras("Projeto seed 9");
            projetoService.save(projeto9);

            Projeto projeto10 = new Projeto();
            projeto10.setCodigo("#001");
            projeto10.setNome("Casa nova para fulano");
            projeto10.setData_de_inicio(sdf.parse("11/11/2024"));
            projeto10.setData_de_termino(sdf.parse("18/11/2024"));
            projeto10.setData_de_checkpoint_status_do_projeto(sdf.parse("13/11/2024"));
            projeto10.setData_de_checkpoint_status_do_pagamento(sdf.parse("13/11/2024"));
            projeto10.setNumero_do_contrato("2024.206-00");
            projeto10.setStatus_do_projeto(1);
            projeto10.setStatus_do_pagamento(1);
            projeto10.setCorretor_do_projeto(corretorService.getById(1));
            projeto10.setCliente_do_projeto(clienteService.getById(1));
            projeto10.setImovel_do_projeto(imovelService.getById(4));
            projeto10.setInformacoes_extras("Projeto seed 1");
            projetoService.save(projeto10);
            
            
            // Criando as Metas

            Meta meta1 = new Meta();

            meta1.setNome("Meta de Vendas 1");
            meta1.setData_limite(sdf.parse("30/11/2024"));
            meta1.setTipo_de_meta(1);
            meta1.setQuantidade_meta(new BigDecimal(1.0));
            meta1.setTipo_de_recompensa(1);
            meta1.setRecompensa(new BigDecimal(1000.00));
            meta1.setInformacoes_extras("Meta seed 1");
            
            metaService.save(meta1);

            Meta meta2 = new Meta();
            meta2.setNome("Meta de Vendas 2");
            meta2.setData_limite(sdf.parse("30/12/2024"));
            meta2.setTipo_de_meta(1);
            meta2.setQuantidade_meta(new BigDecimal(1.0));
            meta2.setTipo_de_recompensa(1);
            meta2.setRecompensa(new BigDecimal(1000.00));
            meta2.setInformacoes_extras("Meta seed 2");
            metaService.save(meta2);

            Meta meta3 = new Meta();
            meta3.setNome("Meta de Vendas 3");
            meta3.setData_limite(sdf.parse("31/01/2025"));
            meta3.setTipo_de_meta(1);
            meta3.setQuantidade_meta(new BigDecimal(1.0));
            meta3.setTipo_de_recompensa(1);
            meta3.setRecompensa(new BigDecimal(1000.00));
            meta3.setInformacoes_extras("Meta seed 3");
            metaService.save(meta3);

            Meta meta4 = new Meta();
            meta4.setNome("Meta de Vendas 4");
            meta4.setData_limite(sdf.parse("28/02/2025"));
            meta4.setTipo_de_meta(1);
            meta4.setQuantidade_meta(new BigDecimal(1.0));
            meta4.setTipo_de_recompensa(1);
            meta4.setRecompensa(new BigDecimal(1000.00));
            meta4.setInformacoes_extras("Meta seed 4");
            metaService.save(meta4);

            Meta meta5 = new Meta();
            meta5.setNome("Meta de Vendas 5");
            meta5.setData_limite(sdf.parse("31/03/2025"));
            meta5.setTipo_de_meta(1);
            meta5.setQuantidade_meta(new BigDecimal(1.0));
            meta5.setTipo_de_recompensa(1);
            meta5.setRecompensa(new BigDecimal(1000.00));
            meta5.setInformacoes_extras("Meta seed 5");
            metaService.save(meta5);

            Meta meta6 = new Meta();
            meta6.setNome("Meta de Vendas 6");
            meta6.setData_limite(sdf.parse("30/04/2025"));
            meta6.setTipo_de_meta(1);
            meta6.setQuantidade_meta(new BigDecimal(1.0));
            meta6.setTipo_de_recompensa(1);
            meta6.setRecompensa(new BigDecimal(1000.00));
            meta6.setInformacoes_extras("Meta seed 6");
            metaService.save(meta6);

            Meta meta7 = new Meta();
            meta7.setNome("Meta de Vendas 7");
            meta7.setData_limite(sdf.parse("31/05/2025"));
            meta7.setTipo_de_meta(1);
            meta7.setQuantidade_meta(new BigDecimal(1.0));
            meta7.setTipo_de_recompensa(1);
            meta7.setRecompensa(new BigDecimal(1000.00));
            meta7.setInformacoes_extras("Meta seed 7");
            metaService.save(meta7);

            Meta meta8 = new Meta();
            meta8.setNome("Meta de Vendas 8");
            meta8.setData_limite(sdf.parse("15/11/2025"));
            meta8.setTipo_de_meta(1);
            meta8.setQuantidade_meta(new BigDecimal(1.0));
            meta8.setTipo_de_recompensa(1);
            meta8.setRecompensa(new BigDecimal(1000.00));
            meta8.setInformacoes_extras("Meta seed 8");
            metaService.save(meta8);

            Meta meta9 = new Meta();
            meta9.setNome("Meta de Vendas 9");
            meta9.setData_limite(sdf.parse("15/11/2024"));
            meta9.setTipo_de_meta(1);
            meta9.setQuantidade_meta(new BigDecimal(1.0));
            meta9.setTipo_de_recompensa(1);
            meta9.setRecompensa(new BigDecimal(1000.00));
            meta9.setInformacoes_extras("Meta seed 9");
            metaService.save(meta9);

            Meta meta10 = new Meta();
            meta10.setNome("Meta de Vendas 10");
            meta10.setData_limite(sdf.parse("15/11/2024"));
            meta10.setTipo_de_meta(1);
            meta10.setQuantidade_meta(new BigDecimal(1.0));
            meta10.setTipo_de_recompensa(1);
            meta10.setRecompensa(new BigDecimal(1000.00));
            meta10.setInformacoes_extras("Meta seed 10");
            metaService.save(meta10);
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
        

               


    }   
}
