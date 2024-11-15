package com.meusalugueis.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meusalugueis.demo.entity.Cliente;
import com.meusalugueis.demo.entity.Corretor;
import com.meusalugueis.demo.entity.Imovel;
import com.meusalugueis.demo.entity.Projeto;

@Service
public interface ProjetoService {

    List<Projeto> getAll();

    Projeto save(Projeto projeto);

    Projeto delete(long id);

    Projeto getById(long id);

    List<Projeto> findByCliente_do_projeto(Cliente cliente);

    List<Projeto> findByCorretor_do_projeto(Corretor corretor);

    List<Projeto> findByImovel_do_projeto(Imovel imovel);

}
