package com.meusalugueis.demo.entity;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Corretor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 1000, nullable = false)
    private String nome;

    @Column(length = 1000, nullable = false)
    private String sobrenome;

    @Column(length = 1000, nullable = false)
    private String rg;

    @Column(length = 1000, nullable = false)
    private String cpf;

    @Column(length = 1000, nullable = false)
    private String creci;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data_de_nascimento;

    @Column(length = 1000, nullable = false)
    private double comissao;

    @Column(length = 1000, nullable = false)
    private String email;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime data_de_criacao_do_registro;

    @UpdateTimestamp
    @Column()
    private LocalDateTime data_de_ultima_alteracao;

    @Lob
    @Column(name = "foto_do_corretor")
    private byte[] fotoDoCorretor;

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

    public String getCreci() {
        return creci;
    }

    public void setCreci(String creci) {
        this.creci = creci;
    }

    public Date getData_de_nascimento() {
        return data_de_nascimento;
    }

    public void setData_de_nascimento(Date data_de_nascimento) {
        this.data_de_nascimento = data_de_nascimento;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
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
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getFotoDoCorretor() {
        return fotoDoCorretor;
    }
    
    public void setFotoDoCorretor(byte[] fotoDoCorretor) {
        this.fotoDoCorretor = fotoDoCorretor;
    }
    
    public void salvarFoto(MultipartFile foto) throws IOException {

        String pasta = System.getProperty("user.dir") + "/src/main/resources/static/corretores/";
        File diretorio = new File(pasta);
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }

        String caminho = pasta + "foto_de_corretor_" + this.id + ".jpg";
        File arquivo = new File(caminho);
        foto.transferTo(arquivo);
    }
}
