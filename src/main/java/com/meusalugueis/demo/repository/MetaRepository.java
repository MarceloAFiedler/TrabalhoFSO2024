package com.meusalugueis.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meusalugueis.demo.entity.Meta;

@Repository
public interface MetaRepository extends JpaRepository<Meta, Long> {

}
