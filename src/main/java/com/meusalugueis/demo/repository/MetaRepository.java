package com.meusalugueis.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.meusalugueis.demo.entity.Meta;

@Repository
public interface MetaRepository extends JpaRepository<Meta, Long> {

    @Query("SELECT m FROM Meta m WHERE m.data_limite <= :data")
    List<Meta> findByData_limiteLessThanEqual(@Param("data") Date data);
    
}
