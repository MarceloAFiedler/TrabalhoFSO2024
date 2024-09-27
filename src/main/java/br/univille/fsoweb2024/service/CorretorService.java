package br.univille.fsoweb2024.service;

import java.util.List;

import br.univille.fsoweb2024.entity.Corretor;

public interface CorretorService {
    List<Corretor> getAll();
    Corretor save(Corretor corretor);
    Corretor delete(long id);
    Corretor getByID(long id);
}
