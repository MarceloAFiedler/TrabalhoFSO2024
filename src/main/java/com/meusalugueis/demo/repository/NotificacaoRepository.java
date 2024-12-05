package com.meusalugueis.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.meusalugueis.demo.entity.Notificacao;

import jakarta.transaction.Transactional;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {
    
    @Transactional
    @Modifying
    @Query("DELETE FROM Notificacao n WHERE n.origem = :origem")
    void deleteByOrigem(@Param("origem") int origem);
    
}

