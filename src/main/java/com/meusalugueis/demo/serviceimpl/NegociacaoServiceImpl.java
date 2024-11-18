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
import com.meusalugueis.demo.service.NegociacaoService;

@Service
public class NegociacaoServiceImpl implements NegociacaoService {

    @Autowired
    private NegociacaoRepository negociacaoRepository;

    @Override
    public List<Negociacao> getAll(){
        return negociacaoRepository.findAll();
    }

    @Override
    public Negociacao save(Negociacao negociacao){
        return negociacaoRepository.save(negociacao);
    }

    @Override
    public Negociacao delete(long id){
        var retorno = negociacaoRepository.findById(id);
        if(retorno.isPresent()){
            negociacaoRepository.deleteById(id);
            return retorno.get();
        }
        return null;

    }

    @Override
    public Negociacao getById(long id){
        var retorno = negociacaoRepository.findById(id);
        if(retorno.isPresent()){
            return retorno.get();
        }
        return null;

    }

    @Override
    public List<Negociacao> findByCorretor_da_negociacao(Corretor corretor) {
        return negociacaoRepository.findByCorretor_da_negociacao(corretor);
    }

    @Override
    public List<Negociacao> findByImovel_da_negociacao(Imovel imovel) {
        return negociacaoRepository.findByImovel_da_negociacao(imovel);
    }

    @Override
    public List<Negociacao> findByCliente_da_negociacao(Cliente cliente) {
        return negociacaoRepository.findByCliente_da_negociacao(cliente);
    }

    @Override
    public List<Negociacao> findByProjeto_da_negociacao(Projeto projeto) {
        return negociacaoRepository.findByProjeto_da_negociacao(projeto);
    }

}
