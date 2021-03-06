package com.micaelps.casadocodigo.novolivro;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.micaelps.casadocodigo.novacategoria.Categoria;
import com.micaelps.casadocodigo.novoautor.Autor;
import com.micaelps.casadocodigo.validators.UniqueValue;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @Size(max = 500)
    private String resumo;

    @Lob
    private String sumario;

    @Min(20)
    @NotNull
    private BigDecimal precoLivro;

    @Min(20)
    private Integer numeroPaginas;

    @NotBlank
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    @ManyToOne
    private Categoria categoria;

    @NotNull
    @ManyToOne
    private Autor autor;

    public Livro(String sumario, @NotBlank String titulo, @Size(max = 500) String resumo, @Min(20) @NotNull BigDecimal precoLivro, @Min(20) Integer numeroPaginas, @NotBlank String isbn, @Future LocalDate dataPublicacao, @NotNull Categoria categoria, @NotNull Autor autor) {
        this.sumario = sumario;
        this.titulo = titulo;
        this.resumo = resumo;
        this.precoLivro = precoLivro;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Livro() {
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", precoLivro=" + precoLivro +
                ", numeroPaginas=" + numeroPaginas +
                ", isbn='" + isbn + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", categoria=" + categoria +
                ", autor=" + autor +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPrecoLivro() {
        return precoLivro;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }
}
