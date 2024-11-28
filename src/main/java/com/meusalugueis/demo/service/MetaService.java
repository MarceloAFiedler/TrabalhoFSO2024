package com.meusalugueis.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;


import com.meusalugueis.demo.entity.Corretor;
import com.meusalugueis.demo.entity.Meta;


@Service
public interface MetaService {

    List<Meta> getAll();

    Meta save(Meta meta);

    Meta delete(long id);

    Meta getById(long id);

    List<Meta> findByData_limiteLessThanEqual(Date data);

    List<Meta> findByCorretor(Corretor corretor);

}
