package com.meusalugueis.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meusalugueis.demo.entity.Cliente;
import com.meusalugueis.demo.entity.Corretor;
import com.meusalugueis.demo.repository.ClienteRepository;
import com.meusalugueis.demo.repository.CorretorRepository;
import com.meusalugueis.demo.service.CorretorService;

@Service
public class CorretorServiceImpl implements CorretorService {

    @Autowired
    private CorretorRepository corretorRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Corretor> getAll(){
        return corretorRepository.findAll();
    }

    @Override
    public Corretor save(Corretor corretor){
        corretorRepository.save(corretor);
        return corretor;
    }

    @Override
    public Corretor delete(long id) {
    var retorno = corretorRepository.findById(id);
    if(retorno.isPresent()){
        // Find all clients with this corretor and set their corretor_responsavel to null
        var clientesDoCorretor = clienteRepository.findByCorretor_responsavel(retorno.get());
        for(Cliente cliente : clientesDoCorretor) {
            cliente.setCorretor_responsavel(null);
            clienteRepository.save(cliente);
        }
        
        // Now we can safely delete the corretor
        corretorRepository.deleteById(id);
        return retorno.get();
    }
    return null;
    }

    @Override
    public Corretor getById(long id){
        var retorno = corretorRepository.findById(id);
        if(retorno.isPresent())
            return retorno.get();
        return null;
    }
}
