package com.meusalugueis.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meusalugueis.demo.entity.Cliente;
import com.meusalugueis.demo.entity.Imovel;
import com.meusalugueis.demo.entity.Negociacao;
import com.meusalugueis.demo.entity.Projeto;
import com.meusalugueis.demo.repository.ImovelRepository;
import com.meusalugueis.demo.repository.NegociacaoRepository;
import com.meusalugueis.demo.repository.ProjetoRepository;
import com.meusalugueis.demo.service.ImovelService;

@Service
public class ImovelServiceImpl implements ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private NegociacaoRepository negociacaoRepository;

    @Override
    public List<Imovel> getAll(){
        return imovelRepository.findAll();
    }

    @Override
    public Imovel save(Imovel imovel){
        imovelRepository.save(imovel);
        return imovel;
    }

    @Override
    public Imovel delete(long id) {
        var retorno = imovelRepository.findById(id);
        if(retorno.isPresent()){
            imovelRepository.deleteById(id);
            return retorno.get();
        }
        return null;
    }

    @Override
    public Imovel getById(long id){
        var retorno = imovelRepository.findById(id);

        var projetosDoImovel = projetoRepository.findByImovel_do_projeto(retorno.get());
            for(Projeto projeto : projetosDoImovel) {
                projeto.setImovel_do_projeto(null);
                projetoRepository.save(projeto);
        }

        var negociacoesDoImovel = negociacaoRepository.findByImovel_da_negociacao(retorno.get());
            for(Negociacao negociacao : negociacoesDoImovel) {
                negociacao.setImovel_da_negociacao(null);
                negociacaoRepository.save(negociacao);
            }

        if(retorno.isPresent())
            return retorno.get();
        return null;
    }

    @Override
    public List<Imovel> findByCliente_proprietario(Cliente cliente) {
        return imovelRepository.findByCliente_proprietario(cliente);
    }


}
