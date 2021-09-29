package br.com.zupacademy.gui.casadocodigo.models.dto;

import br.com.zupacademy.gui.casadocodigo.models.Livro;
import org.springframework.util.Assert;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class LivroDTO {
    @NotBlank
    private Long id;
    @NotBlank
    private String titulo;

    public LivroDTO(Livro livro){
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public static List<LivroDTO> converterListaLivros(List<Livro> resultList) {
        List<LivroDTO> listaLivrosDTO = new ArrayList<>();
        resultList.forEach(livro -> {
            listaLivrosDTO.add(new LivroDTO(livro));
        });
        return listaLivrosDTO;
    }

    @Override
    public String toString() {
        return "LivroDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
