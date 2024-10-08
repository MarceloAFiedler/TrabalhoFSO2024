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
        repository.save(corretor);
        return corretor;
    }

    @Override
    public Corretor delete(long id) {
        var retorno = repository.findById(id);
        if(retorno.isPresent()){
            repository.deleteById(id);
            return retorno.get();
        }
        return null;
    }

    @Override
    public Corretor getByID(long id) {
        var retorno = repository.findById(id);
        if (retorno.isPresent())
            return retorno.get();
        return null;
    }
    
}
