package com.meusalugueis.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meusalugueis.demo.entity.Cliente;
import com.meusalugueis.demo.entity.Imovel;
import com.meusalugueis.demo.repository.ImovelRepository;
import com.meusalugueis.demo.service.ImovelService;

@Service
public class ImovelServiceImpl implements ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

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
        if(retorno.isPresent())
            return retorno.get();
        return null;
    }

    @Override
    public List<Imovel> findByCliente_proprietario(Cliente cliente) {
        return imovelRepository.findByCliente_proprietario(cliente);
    }


}
