package com.meusalugueis.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meusalugueis.demo.entity.Cliente;
import com.meusalugueis.demo.entity.Corretor;
import com.meusalugueis.demo.entity.Meta;
import com.meusalugueis.demo.entity.Negociacao;
import com.meusalugueis.demo.entity.Projeto;
import com.meusalugueis.demo.repository.ClienteRepository;
import com.meusalugueis.demo.repository.CorretorRepository;
import com.meusalugueis.demo.repository.MetaRepository;
import com.meusalugueis.demo.repository.ProjetoRepository;
import com.meusalugueis.demo.repository.NegociacaoRepository;
import com.meusalugueis.demo.service.CorretorService;

@Service
public class CorretorServiceImpl implements CorretorService {

    @Autowired
    private CorretorRepository corretorRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private NegociacaoRepository negociacaoRepository;

    @Autowired
    private MetaRepository metaRepository;

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
        
        var clientesDoCorretor = clienteRepository.findByCorretor_responsavel(retorno.get());
        for(Cliente cliente : clientesDoCorretor) {
            cliente.setCorretor_responsavel(null);
            clienteRepository.save(cliente);
        }

        var projetosDoCorretor = projetoRepository.findByCorretor_do_projeto(retorno.get());
            for(Projeto projeto : projetosDoCorretor) {
                projeto.setCorretor_do_projeto(null);
                projetoRepository.save(projeto);
        }

        var negociacoesDoCorretor = negociacaoRepository.findByCorretor_da_negociacao(retorno.get());
            for(Negociacao negociacao : negociacoesDoCorretor) {
                negociacao.setCorretor_da_negociacao(null);
                negociacaoRepository.save(negociacao);
            }

        var metasDoCorretor = metaRepository.findByCorretor(retorno.get());
            for(Meta meta : metasDoCorretor) {
                meta.setCorretor(null);
                metaRepository.save(meta);
            }
        
        
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
