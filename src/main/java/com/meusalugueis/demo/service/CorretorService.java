package com.meusalugueis.demo.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.meusalugueis.demo.entity.Corretor;

@Service
public interface CorretorService {

    List<Corretor> getAll();

    Corretor save(Corretor corretor);

    Corretor delete(long id);

    Corretor getById(long id);
}