package com.meusalugueis.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meusalugueis.demo.entity.Cliente;
import com.meusalugueis.demo.entity.Corretor;
import com.meusalugueis.demo.entity.Imovel;
import com.meusalugueis.demo.entity.Negociacao;
import com.meusalugueis.demo.entity.Projeto;
import com.meusalugueis.demo.repository.NegociacaoRepository;
import com.meusalugueis.demo.repository.ProjetoRepository;
import com.meusalugueis.demo.service.ProjetoService;

@Service
public class ProjetoServiceImpl implements ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private NegociacaoRepository negociacaoRepository;

    @Override
    public List<Projeto> getAll() {
        return projetoRepository.findAll();
    }

    @Override
    public Projeto save(Projeto projeto) {
        projetoRepository.save(projeto);
        return projeto;
    }

    @Override
    public Projeto delete(long id) {

        var retorno = projetoRepository.findById(id);

        if(retorno.isPresent()){

            var negociacoesDoProjeto = negociacaoRepository.findByProjeto_da_negociacao(retorno.get());

            for(Negociacao negociacao : negociacoesDoProjeto) {
                negociacao.setProjeto_da_negociacao(null);
                negociacaoRepository.save(negociacao);
            }


            projetoRepository.deleteById(id);
            return retorno.get();
        }
        return null;
    }

    @Override
    public Projeto getById(long id) {

        var retorno = projetoRepository.findById(id); 
        
        if(retorno.isPresent())
            return retorno.get();
        return null;
    }

    @Override
    public List<Projeto> findByCliente_do_projeto(Cliente cliente) {
        return projetoRepository.findByCliente_do_projeto(cliente);
    }

    @Override
    public List<Projeto> findByCorretor_do_projeto(Corretor corretor) {
        return projetoRepository.findByCorretor_do_projeto(corretor);
    }

    @Override
    public List<Projeto> findByImovel_do_projeto(Imovel imovel) {
        return projetoRepository.findByImovel_do_projeto(imovel);
    }

}
