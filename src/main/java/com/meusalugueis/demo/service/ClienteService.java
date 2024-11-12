package com.meusalugueis.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meusalugueis.demo.entity.Cliente;
import com.meusalugueis.demo.entity.Corretor;

@Service
public interface ClienteService {

    List<Cliente> getAll();

    Cliente save(Cliente cliente);

    Cliente delete(long id);

    Cliente getById(long id);

    List<Cliente> findByCorretor_responsavel(Corretor corretor);
}