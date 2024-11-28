package com.meusalugueis.demo.entity;

import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data_do_compromisso;

    @Column(length = 1000, nullable = false)
    private String descricao;

    @Column(length = 1, nullable = false)
    private int dia_da_semana;

    @Column(length = 1, nullable = false)
    private int tipo;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime data_de_criacao_do_registro;

    @UpdateTimestamp
    @Column()
    private LocalDateTime data_de_ultima_alteracao;

    public Date getData_do_compromisso() {
        return data_do_compromisso;
    }

    public void setData_do_compromisso(Date data_do_compromisso) {
        this.data_do_compromisso = data_do_compromisso;
    }

    public int getDia_da_semana() {
        return dia_da_semana;
    }

    public void setDia_da_semana(int dia_da_semana) {
        this.dia_da_semana = dia_da_semana;
    }

    public LocalDateTime getData_de_criacao_do_registro() {
        return data_de_criacao_do_registro;
    }

    public void setData_de_criacao_do_registro(LocalDateTime data_de_criacao_do_registro) {
        this.data_de_criacao_do_registro = data_de_criacao_do_registro;
    }

    public LocalDateTime getData_de_ultima_alteracao() {
        return data_de_ultima_alteracao;
    }

    public void setData_de_ultima_alteracao(LocalDateTime data_de_ultima_alteracao) {
        this.data_de_ultima_alteracao = data_de_ultima_alteracao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

        

}
