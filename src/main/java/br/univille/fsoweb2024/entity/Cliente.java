package br.univille.fsoweb2024.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 1000, nullable = false)
    private String primeiroNome;
    @Column(length = 1000, nullable = false)
    private String segundoNome;
    @Column(length = 1000)
    private String tipoDeCliente;
    //private List<Imoveis> catalogoImoveisDoCliente;
    //private List<Imoveis> listaDeImoveisDeInteresse;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPrimeiroNome() {
        return primeiroNome;
    }
    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }
    public String getSegundoNome() {
        return segundoNome;
    }
    public void setSegundoNome(String segundoNome) {
        this.segundoNome = segundoNome;
    }
    public String getTipoDeCliente() {
        return tipoDeCliente;
    }
    public void setTipoDeCliente(String tipoDeCliente) {
        this.tipoDeCliente = tipoDeCliente;
    }
    
}
