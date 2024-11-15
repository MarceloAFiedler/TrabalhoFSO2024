package com.meusalugueis.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.meusalugueis.demo.entity.Cliente;
import com.meusalugueis.demo.entity.Corretor;
import com.meusalugueis.demo.entity.Meta;
import com.meusalugueis.demo.repository.MetaRepository;

@Service
public interface MetaService {

    List<Meta> getAll();

    Meta save(Meta meta);

    Meta delete(long id);

    Meta getById(long id);

    List<Meta> findByData_limiteLessThanEqual(Date data);

}
