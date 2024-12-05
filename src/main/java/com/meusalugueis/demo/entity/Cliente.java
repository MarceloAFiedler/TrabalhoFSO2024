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
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 1000, nullable = false)
    private String nome;

    @Column(length = 1000, nullable = false)
    private String sobrenome;

    @Column(length = 1000, nullable = false)
    private String tipo;

    @Column(length = 1000, nullable = false)
    private String funcao;

    @Column(length = 1000, nullable = false)
    private String rg;

    @Column(length = 1000, nullable = false)
    private String cpf;

    @Column(length = 1000, nullable = false)
    private String email;

    @Column(length = 1000, nullable = false)
    private String telefone;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data_de_nascimento;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime data_de_criacao_do_registro;

    @UpdateTimestamp
    @Column()
    private LocalDateTime data_de_ultima_alteracao;
    
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn()
    private Corretor corretor_responsavel;

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
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getFuncao() {
        return funcao;
    }
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public Date getData_de_nascimento() {
        return data_de_nascimento;
    }
    public void setData_de_nascimento(Date data_de_nascimento) {
        this.data_de_nascimento = data_de_nascimento;
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
    public Corretor getCorretor_responsavel() {
        return corretor_responsavel;
    }
    public void setCorretor_responsavel(Corretor corretor_responsavel) {
        this.corretor_responsavel = corretor_responsavel;
    }

    

}
