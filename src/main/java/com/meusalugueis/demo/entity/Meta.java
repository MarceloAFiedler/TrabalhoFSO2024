package com.meusalugueis.demo.entity;

import java.math.BigDecimal;
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
public class Meta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 1000, nullable = false)
    private String nome;

    @Column(length = 1000)
    private String informacoes_extras;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data_limite;

    @Column(length = 1, nullable = false)
    private Integer tipo_de_recompensa;

    @Column(precision = 20, scale = 2, nullable = false)
    private BigDecimal recompensa;

    @Column(length = 1, nullable = false)
    private Integer tipo_de_meta;

    @Column(precision = 20, scale = 2, nullable = false)
    private BigDecimal quantidade_meta;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime data_de_criacao_do_registro;

    @UpdateTimestamp
    @Column()
    private LocalDateTime data_de_ultima_alteracao;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn()
    private Corretor corretor;

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

    public String getInformacoes_extras() {
        return informacoes_extras;
    }

    public void setInformacoes_extras(String informacoes_extras) {
        this.informacoes_extras = informacoes_extras;
    }

    public Date getData_limite() {
        return data_limite;
    }

    public void setData_limite(Date data_limite) {
        this.data_limite = data_limite;
    }

    public Integer getTipo_de_recompensa() {
        return tipo_de_recompensa;
    }

    public void setTipo_de_recompensa(Integer tipo_de_recompensa) {
        this.tipo_de_recompensa = tipo_de_recompensa;
    }

    public BigDecimal getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(BigDecimal recompensa) {
        this.recompensa = recompensa;
    }

    public Integer getTipo_de_meta() {
        return tipo_de_meta;
    }

    public void setTipo_de_meta(Integer tipo_de_meta) {
        this.tipo_de_meta = tipo_de_meta;
    }

    public BigDecimal getQuantidade_meta() {
        return quantidade_meta;
    }

    public void setQuantidade_meta(BigDecimal quantidade_meta) {
        this.quantidade_meta = quantidade_meta;
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

    public Corretor getCorretor() {
        return corretor;
    }

    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
    }

    
    
}
