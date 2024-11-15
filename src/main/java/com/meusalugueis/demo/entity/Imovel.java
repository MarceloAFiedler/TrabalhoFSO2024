package com.meusalugueis.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Imovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 1000, nullable = false)
    private String codigo;

    @Column(length = 1000, nullable = false)
    private String nome;

    @Column(length = 1000, nullable = false)
    private String cidade;

    @Column(length = 1000, nullable = false)
    private String estado;

    @Column(length = 1000, nullable = false)
    private String rua;

    @Column(length = 1000, nullable = false)
    private String numero;

    @Column(length = 1000, nullable = false)
    private String cep;

    @Column(length = 1000)
    private String ponto_de_referencia;

    @Column()
    private Integer andares;

    @Column()
    private Integer quantidade_de_quartos;

    @Column()
    private Integer quantidade_de_suites;

    @Column()
    private Integer quantidade_de_cozinhas;


    @Column()
    private Integer quantidade_de_banheiros;

    @Column()
    private Integer quantidade_de_salas;

    @Column()
    private Integer quantidade_de_garagens;

    @Column()
    private Integer quantidade_de_areas_de_servico;

    @Column()
    private Boolean possui_quintal;

    @Column()
    private Boolean mobiliado;

    @Column()
    private Boolean condominio;

    @Column()
    private Boolean elevador;

    @Column()
    private Boolean esquina;

    @Column(precision = 10, scale = 5)
    private BigDecimal comprimento_em_metros;

    @Column(precision = 10, scale = 5)
    private BigDecimal largura_em_metros;

    @Column(length = 1, nullable = false)
    private String venda_ou_aluguel;

    @Column(length = 1, nullable = false)
    private String tipo;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn()
    private Cliente cliente_proprietario;

    @Column(length = 1000)
    private String informacoes_extras;

    @Column(precision = 20, scale = 2)
    private BigDecimal valor;
    
    @Column(length = 10, nullable = false)
    private String status;

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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPonto_de_referencia() {
        return ponto_de_referencia;
    }

    public void setPonto_de_referencia(String ponto_de_referencia) {
        this.ponto_de_referencia = ponto_de_referencia;
    }

    public Integer getAndares() {
        return andares;
    }

    public void setAndares(Integer andares) {
        this.andares = andares;
    }

    public Integer getQuantidade_de_quartos() {
        return quantidade_de_quartos;
    }

    public void setQuantidade_de_quartos(Integer quantidade_de_quartos) {
        this.quantidade_de_quartos = quantidade_de_quartos;
    }

    public Integer getQuantidade_de_suites() {
        return quantidade_de_suites;
    }

    public void setQuantidade_de_suites(Integer quantidade_de_suites) {
        this.quantidade_de_suites = quantidade_de_suites;
    }

    public Integer getQuantidade_de_cozinhas() {
        return quantidade_de_cozinhas;
    }

    public void setQuantidade_de_cozinhas(Integer quantidade_de_cozinhas) {
        this.quantidade_de_cozinhas = quantidade_de_cozinhas;
    }

    public Integer getQuantidade_de_banheiros() {
        return quantidade_de_banheiros;
    }

    public void setQuantidade_de_banheiros(Integer quantidade_de_banheiros) {
        this.quantidade_de_banheiros = quantidade_de_banheiros;
    }

    public Integer getQuantidade_de_salas() {
        return quantidade_de_salas;
    }

    public void setQuantidade_de_salas(Integer quantidade_de_salas) {
        this.quantidade_de_salas = quantidade_de_salas;
    }

    public Integer getQuantidade_de_garagens() {
        return quantidade_de_garagens;
    }

    public void setQuantidade_de_garagens(Integer quantidade_de_garagens) {
        this.quantidade_de_garagens = quantidade_de_garagens;
    }

    public Integer getQuantidade_de_areas_de_servico() {
        return quantidade_de_areas_de_servico;
    }

    public void setQuantidade_de_areas_de_servico(Integer quantidade_de_areas_de_servico) {
        this.quantidade_de_areas_de_servico = quantidade_de_areas_de_servico;
    }

    public Boolean getPossui_quintal() {
        return possui_quintal;
    }

    public void setPossui_quintal(Boolean possui_quintal) {
        this.possui_quintal = possui_quintal;
    }

    public Boolean getMobiliado() {
        return mobiliado;
    }

    public void setMobiliado(Boolean mobiliado) {
        this.mobiliado = mobiliado;
    }

    public Boolean getCondominio() {
        return condominio;
    }

    public void setCondominio(Boolean condominio) {
        this.condominio = condominio;
    }

    public Boolean getElevador() {
        return elevador;
    }

    public void setElevador(Boolean elevador) {
        this.elevador = elevador;
    }

    public Boolean getEsquina() {
        return esquina;
    }

    public void setEsquina(Boolean esquina) {
        this.esquina = esquina;
    }

    public BigDecimal getComprimento_em_metros() {
        return comprimento_em_metros;
    }

    public void setComprimento_em_metros(BigDecimal comprimento_em_metros) {
        this.comprimento_em_metros = comprimento_em_metros;
    }

    public BigDecimal getLargura_em_metros() {
        return largura_em_metros;
    }

    public void setLargura_em_metros(BigDecimal largura_em_metros) {
        this.largura_em_metros = largura_em_metros;
    }

    public String getVenda_ou_aluguel() {
        return venda_ou_aluguel;
    }

    public void setVenda_ou_aluguel(String venda_ou_aluguel) {
        this.venda_ou_aluguel = venda_ou_aluguel;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cliente getCliente_proprietario() {
        return cliente_proprietario;
    }
    // ver depois
    public void setCliente_proprietario(Cliente cliente_proprietario) {
        this.cliente_proprietario = cliente_proprietario;
    }

    public String getInformacoes_extras() {
        return informacoes_extras;
    }

    public void setInformacoes_extras(String informacoes_extras) {
        this.informacoes_extras = informacoes_extras;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
