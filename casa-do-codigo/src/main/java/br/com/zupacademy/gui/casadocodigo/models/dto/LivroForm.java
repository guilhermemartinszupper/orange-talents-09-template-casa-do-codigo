package br.com.zupacademy.gui.casadocodigo.models.dto;
import br.com.zupacademy.gui.casadocodigo.configs.validators.annotations.IdExist;
import br.com.zupacademy.gui.casadocodigo.configs.validators.annotations.UniqueField;
import br.com.zupacademy.gui.casadocodigo.models.Autor;
import br.com.zupacademy.gui.casadocodigo.models.Categoria;
import br.com.zupacademy.gui.casadocodigo.models.Livro;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;


public class LivroForm {

    @NotBlank @UniqueField(domainClass = Livro.class, nomeCampo = "titulo")
    private String titulo;
    @NotBlank @Length(max = 500)
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull @Min(20)
    private BigDecimal preco;
    @NotNull @Min(100)
    private Integer numeroPaginas;
    @NotBlank @UniqueField(domainClass = Livro.class, nomeCampo = "isbn")
    private String isbn;
    @NotNull @Future
    private LocalDate publicacao;
    @NotNull @IdExist(domainClass = Categoria.class)
    private Long idCategoria;
    @NotNull @IdExist(domainClass = Autor.class)
    private Long idAutor;

    @Deprecated
    public LivroForm() {
    }

    public LivroForm(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroPaginas, String isbn, LocalDate publicacao, Long idCategoria, Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.publicacao = publicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public Livro converter(EntityManager entityManager) {
        Categoria categoria = entityManager.find(Categoria.class, this.idCategoria);
        Autor autor = entityManager.find(Autor.class, this.idAutor);
        return new Livro(this.titulo,this.resumo,this.sumario,this.preco,this.numeroPaginas,this.isbn,this.publicacao,
                categoria,autor);
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

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublicacao() {
        return publicacao;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    @Override
    public String toString() {
        return "LivroForm{" +
                "titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", numeroPaginas=" + numeroPaginas +
                ", isbn='" + isbn + '\'' +
                ", publicacao=" + publicacao +
                ", idCategoria=" + idCategoria +
                ", idAutor=" + idAutor +
                '}';
    }
}
