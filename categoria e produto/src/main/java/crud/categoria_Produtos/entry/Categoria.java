package crud.categoria_Produtos.entry;

import crud.categoria_Produtos.util.IdUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity(name = "Categoria")
@Table(name = "categoria")

public class Categoria {

    @Id
    private String id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Column(name = "codigoDeBarras", nullable = false)
    private String codigoDeBarras;

    @Column(name = "quantidade", nullable = false)
    private Double quantidade;

    @Column(name = "precoCusto", nullable = false)
    private Double precoCusto;

    @Column(name = "precoVenda", nullable = false)
    private Double precoVenda;

    @Column(name = "data_criacao", nullable = false, columnDefinition = "TIMESTAMP(6)")
    private LocalDateTime dataCriacao;

    public Categoria() {}

    public Categoria(String id, String nome, String descricao, String marca, String categoria, String codigoDeBarras, Double quantidade, Double precoCusto, Double precoVenda, LocalDateTime dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.marca = marca;
        this.categoria = categoria;
        this.codigoDeBarras = codigoDeBarras;
        this.quantidade = quantidade;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.dataCriacao = dataCriacao;
    }

    public static Categoria novaCategoria(String nome, String descricao, String marca, String categoria, String codigoDeBarras, Double quantidade, Double precoCusto, Double precoVenda) {
        String id = IdUtils.uuid();
        LocalDateTime dataCriacao = LocalDateTime.now();
        return new Categoria(id, nome, descricao, marca, categoria, codigoDeBarras, quantidade, precoCusto, precoVenda, dataCriacao);
    }

    public Categoria atualizar(String descricao, String codigoDeBarras, Double quantidade){
        this.descricao = descricao;
        this.codigoDeBarras = codigoDeBarras;
        this.quantidade = quantidade;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getMarca() {
        return marca;
    }
    public String getCategoria() {
        return categoria;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public Double getPrecoCusto() {
        return precoCusto;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }


    



}
