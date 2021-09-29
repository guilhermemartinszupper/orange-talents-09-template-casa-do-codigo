package br.com.zupacademy.gui.casadocodigo.models.dto;
import br.com.zupacademy.gui.casadocodigo.models.Livro;
import org.springframework.util.Assert;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroDetalhadoDTO {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroPaginas;
    private String isbn;
    private LocalDate publicacao;
    private String categoria;
    private AutorDto autor;

    public LivroDetalhadoDTO(Livro livro) {
        Assert.notNull(livro, "Livro não Pode ser nulo");
        Assert.isTrue(livro.getTitulo() != null, "Livro não Pode ter titulo Nulo");
        Assert.isTrue(livro.getPreco() != null, "Livro não Pode ter Preço Nulo");
        Assert.isTrue(livro.getAutor() != null, "Livro não Pode ter Autor Nulo");
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
        this.publicacao = livro.getPublicacao();
        this.categoria = livro.getCategoria().getNome();
        this.autor = new AutorDto(livro.getAutor());
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

    public String getCategoria() {
        return categoria;
    }

    public AutorDto getAutor() {
        return autor;
    }
}
