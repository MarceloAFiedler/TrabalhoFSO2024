package com.meusalugueis.demo.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Notificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 1000, nullable = false)
    private String nome_da_notificacao;

    @Column(length = 1, nullable = false)
    private Integer tipo_de_notificacao;

    @Column(length = 1, nullable = false)
    private Integer origem;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date data_de_notificacao;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome_da_notificacao() {
        return nome_da_notificacao;
    }

    public void setNome_da_notificacao(String nome_da_notificacao) {
        this.nome_da_notificacao = nome_da_notificacao;
    }

    public Integer getTipo_de_notificacao() {
        return tipo_de_notificacao;
    }

    public void setTipo_de_notificacao(Integer tipo_de_notificacao) {
        this.tipo_de_notificacao = tipo_de_notificacao;
    }

    public Date getData_de_notificacao() {
        return data_de_notificacao;
    }

    public void setData_de_notificacao(Date data_de_notificacao) {
        this.data_de_notificacao = data_de_notificacao;
    }

    public Integer getOrigem() {
        return origem;
    }

    public void setOrigem(Integer origem) {
        this.origem = origem;
    }
}
