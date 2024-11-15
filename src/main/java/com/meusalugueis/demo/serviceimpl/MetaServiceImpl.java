package com.meusalugueis.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meusalugueis.demo.entity.Meta;
import com.meusalugueis.demo.repository.MetaRepository;
import com.meusalugueis.demo.service.MetaService;

@Service
public class MetaServiceImpl implements MetaService{

    @Autowired
    private MetaRepository metaRepository;
    
    @Override
    public List<Meta> getAll(){
        return metaRepository.findAll();
    }
    
    @Override
    public Meta save(Meta meta){
        metaRepository.save(meta);
        return meta;
    }

    @Override
    public Meta delete(long id){
        var retorno = metaRepository.findById(id);
        if(retorno.isPresent()){
            metaRepository.deleteById(id);
            return retorno.get();
        }
        return null;
    }
    
    @Override
    public Meta getById(long id){
        var retorno = metaRepository.findById(id);
        if(retorno.isPresent()){
            return retorno.get();
        }
        return null;
    }
}
