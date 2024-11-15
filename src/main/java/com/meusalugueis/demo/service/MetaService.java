package com.meusalugueis.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meusalugueis.demo.entity.Meta;

@Service
public interface MetaService {

    List<Meta> getAll();

    Meta save(Meta meta);

    Meta delete(long id);

    Meta getById(long id);

}
