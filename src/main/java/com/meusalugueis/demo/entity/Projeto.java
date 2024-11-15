package com.meusalugueis.demo.entity;

import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 1000, nullable = false)
    private String codigo;

    @Column(length = 1000, nullable = false)
    private String nome;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data_de_inicio;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data_de_termino;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data_de_checkpoint_status_do_projeto;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data_de_checkpoint_status_do_pagamento;

    @Column(length = 1000)
    private String numero_do_contrato;

    @Column(length = 1, nullable = false)
    private Integer status_do_projeto;

    @Column(length = 1, nullable = false)
    private Integer status_do_pagamento;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn()
    private Corretor corretor_do_projeto;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn()
    private Cliente cliente_do_projeto;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn()
    private Imovel imovel_do_projeto;

    @Column(length = 1000)
    private String informacoes_extras;

        @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime data_de_criacao_do_registro;
    
    @UpdateTimestamp
    @Column()
    private LocalDateTime data_de_ultima_alteracao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_de_inicio() {
        return data_de_inicio;
    }

    public void setData_de_inicio(Date data_de_inicio) {
        this.data_de_inicio = data_de_inicio;
    }

    public Date getData_de_termino() {
        return data_de_termino;
    }

    public void setData_de_termino(Date data_de_termino) {
        this.data_de_termino = data_de_termino;
    }

    public Date getData_de_checkpoint_status_do_projeto() {
        return data_de_checkpoint_status_do_projeto;
    }

    public void setData_de_checkpoint_status_do_projeto(Date data_de_checkpoint_status_do_projeto) {
        this.data_de_checkpoint_status_do_projeto = data_de_checkpoint_status_do_projeto;
    }

    public Date getData_de_checkpoint_status_do_pagamento() {
        return data_de_checkpoint_status_do_pagamento;
    }

    public void setData_de_checkpoint_status_do_pagamento(Date data_de_checkpoint_status_do_pagamento) {
        this.data_de_checkpoint_status_do_pagamento = data_de_checkpoint_status_do_pagamento;
    }

    public String getNumero_do_contrato() {
        return numero_do_contrato;
    }

    public void setNumero_do_contrato(String numero_do_contrato) {
        this.numero_do_contrato = numero_do_contrato;
    }

    public Integer getStatus_do_projeto() {
        return status_do_projeto;
    }

    public void setStatus_do_projeto(Integer status_do_projeto) {
        this.status_do_projeto = status_do_projeto;
    }

    public Integer getStatus_do_pagamento() {
        return status_do_pagamento;
    }

    public void setStatus_do_pagamento(Integer status_do_pagamento) {
        this.status_do_pagamento = status_do_pagamento;
    }

    public Corretor getCorretor_do_projeto() {
        return corretor_do_projeto;
    }

    public void setCorretor_do_projeto(Corretor corretor_do_projeto) {
        this.corretor_do_projeto = corretor_do_projeto;
    }

    public Cliente getCliente_do_projeto() {
        return cliente_do_projeto;
    }

    public void setCliente_do_projeto(Cliente cliente_do_projeto) {
        this.cliente_do_projeto = cliente_do_projeto;
    }

    public Imovel getImovel_do_projeto() {
        return imovel_do_projeto;
    }

    public void setImovel_do_projeto(Imovel imovel_do_projeto) {
        this.imovel_do_projeto = imovel_do_projeto;
    }

    public String getInformacoes_extras() {
        return informacoes_extras;
    }

    public void setInformacoes_extras(String informacoes_extras) {
        this.informacoes_extras = informacoes_extras;
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

    
    
}
