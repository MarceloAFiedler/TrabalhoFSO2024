package br.univille.fsoweb2024.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Corretor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 1000, nullable = false)
    public String primeiroNome;
    @Column(length = 1000, nullable = false)
    public String segundoNome;
    @Column(length = 1000)
    public String email;
    
    //+List<Meta> metas
    //+List<Clientes> carteiraDeClientes
    public long getId() {
        return id;
    }
    public void setId(long id) {
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    
}
