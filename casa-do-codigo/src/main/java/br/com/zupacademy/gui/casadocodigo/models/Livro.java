package br.com.zupacademy.gui.casadocodigo.models;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
public class Livro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Column(nullable = false)
    private String titulo;
    @NotBlank @Length(max = 500) @Column(nullable = false,length = 500)
    private String resumo;
    @NotBlank @Column(columnDefinition = "Text",nullable = false)
    private String sumario;
    @NotNull @Min(20)
    private BigDecimal preco;
    @NotNull @Min(100)
    private Integer numeroPaginas;
    @NotNull @NotBlank
    private String isbn;
    @NotNull @Future
    private LocalDate publicacao;
    @NotNull@ManyToOne
    private Categoria categoria;
    @NotNull @ManyToOne
    private Autor autor;

    @Deprecated
    public Livro() {
    }


    public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroPaginas, String isbn, LocalDate publicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.publicacao = publicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", numeroPaginas=" + numeroPaginas +
                ", isbn='" + isbn + '\'' +
                ", publicacao=" + publicacao +
                ", categoria=" + categoria +
                ", autor=" + autor +
                '}';
    }
}
