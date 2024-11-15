package com.meusalugueis.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meusalugueis.demo.entity.Cliente;
import com.meusalugueis.demo.entity.Corretor;
import com.meusalugueis.demo.entity.Imovel;
import com.meusalugueis.demo.entity.Projeto;
import com.meusalugueis.demo.repository.ClienteRepository;
import com.meusalugueis.demo.repository.ImovelRepository;
import com.meusalugueis.demo.repository.ProjetoRepository;
import com.meusalugueis.demo.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ImovelRepository imovelRepository;

    @Autowired ProjetoRepository projetoRepository;

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
            var imoveisDoCliente = imovelRepository.findByCliente_proprietario(retorno.get());
                 for(Imovel imovel : imoveisDoCliente) {
                     imovel.setCliente_proprietario(null);
                    imovelRepository.save(imovel);
                 }
            
            var projetosDoCliente = projetoRepository.findByCliente_do_projeto(retorno.get());
                for(Projeto projeto : projetosDoCliente) {
                    projeto.setCliente_do_projeto(null);
                    projetoRepository.save(projeto);
                }

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
