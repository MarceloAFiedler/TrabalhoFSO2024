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
public class Negociacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 1000, nullable = false)
    private String nome;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data_de_inicio;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data_de_termino;

    @Column(length = 1000, nullable = false)
    private int origem_da_negociacao;

    @Column(length = 1, nullable = false)
    private int tipo_de_negociacao;

    @Column(length = 1, nullable = false)
    private int fase_de_negociacao;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data_de_checkpoint_da_fase;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn()
    private Corretor corretor_da_negociacao;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn()
    private Cliente cliente_da_negociacao;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn()
    private Imovel imovel_da_negociacao;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn()
    private Projeto projeto_da_negociacao;

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

    public int getOrigem_da_negociacao() {
        return origem_da_negociacao;
    }

    public void setOrigem_da_negociacao(int origem_da_negociacao) {
        this.origem_da_negociacao = origem_da_negociacao;
    }

    public int getTipo_de_negociacao() {
        return tipo_de_negociacao;
    }

    public void setTipo_de_negociacao(int tipo_de_negociacao) {
        this.tipo_de_negociacao = tipo_de_negociacao;
    }

    public int getFase_de_negociacao() {
        return fase_de_negociacao;
    }

    public void setFase_de_negociacao(int fase_de_negociacao) {
        this.fase_de_negociacao = fase_de_negociacao;
    }

    public Date getData_de_checkpoint_da_fase() {
        return data_de_checkpoint_da_fase;
    }

    public void setData_de_checkpoint_da_fase(Date data_de_checkpoint_da_fase) {
        this.data_de_checkpoint_da_fase = data_de_checkpoint_da_fase;
    }

    public Corretor getCorretor_da_negociacao() {
        return corretor_da_negociacao;
    }

    public void setCorretor_da_negociacao(Corretor corretor_da_negociacao) {
        this.corretor_da_negociacao = corretor_da_negociacao;
    }

    public Cliente getCliente_da_negociacao() {
        return cliente_da_negociacao;
    }

    public void setCliente_da_negociacao(Cliente cliente_da_negociacao) {
        this.cliente_da_negociacao = cliente_da_negociacao;
    }

    public Imovel getImovel_da_negociacao() {
        return imovel_da_negociacao;
    }

    public void setImovel_da_negociacao(Imovel imovel_da_negociacao) {
        this.imovel_da_negociacao = imovel_da_negociacao;
    }

    public Projeto getProjeto_da_negociacao() {
        return projeto_da_negociacao;
    }

    public void setProjeto_da_negociacao(Projeto projeto_da_negociacao) {
        this.projeto_da_negociacao = projeto_da_negociacao;
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
