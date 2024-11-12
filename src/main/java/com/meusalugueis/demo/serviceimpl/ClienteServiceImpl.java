package com.meusalugueis.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meusalugueis.demo.entity.Cliente;
import com.meusalugueis.demo.entity.Corretor;
import com.meusalugueis.demo.repository.ClienteRepository;
import com.meusalugueis.demo.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getAll(){
        return clienteRepository.findAll();
    }

    @Override
    public Cliente save(Cliente cliente){
        clienteRepository.save(cliente);
        return cliente;
    }

    @Override
    public Cliente delete(long id) {
        var retorno = clienteRepository.findById(id);
        if(retorno.isPresent()){
            clienteRepository.deleteById(id);
            return retorno.get();
        }
        return null;
    }

    @Override
    public Cliente getById(long id){
        var retorno = clienteRepository.findById(id);
        if(retorno.isPresent())
            return retorno.get();
        return null;
    }

    @Override
    public List<Cliente> findByCorretor_responsavel(Corretor corretor) {
        return clienteRepository.findByCorretor_responsavel(corretor);
    }


}
