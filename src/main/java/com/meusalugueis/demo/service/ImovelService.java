package com.meusalugueis.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meusalugueis.demo.entity.Cliente;
import com.meusalugueis.demo.entity.Imovel;

@Service
public interface ImovelService{

    List<Imovel> getAll();

    Imovel save(Imovel cliente);

    Imovel delete(long id);

    Imovel getById(long id);

    List<Imovel> findByCliente_proprietario(Cliente cliente);
}

