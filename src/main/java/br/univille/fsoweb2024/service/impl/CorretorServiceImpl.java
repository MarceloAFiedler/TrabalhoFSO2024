package br.univille.fsoweb2024.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.fsoweb2024.entity.Corretor;
import br.univille.fsoweb2024.repository.CorretorRepository;
import br.univille.fsoweb2024.service.CorretorService;

@Service
public class CorretorServiceImpl implements CorretorService{

    @Autowired
    private CorretorRepository repository;
    @Override
    public List<Corretor> getAll() {
        return repository.findAll();
    }

    @Override
    public Corretor save(Corretor corretor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Corretor delete(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Corretor getByID(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByID'");
    }
    
}
