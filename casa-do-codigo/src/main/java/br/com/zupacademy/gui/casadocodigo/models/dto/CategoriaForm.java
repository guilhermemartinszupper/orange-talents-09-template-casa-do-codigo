package br.com.zupacademy.gui.casadocodigo.models.dto;

import br.com.zupacademy.gui.casadocodigo.configs.validators.annotations.UniqueField;
import br.com.zupacademy.gui.casadocodigo.models.Categoria;

import javax.validation.constraints.NotBlank;



public class CategoriaForm {
    @NotBlank @UniqueField(domainClass = Categoria.class,nomeCampo = "nome")
    private String nome;

    @Deprecated
    public CategoriaForm() {
    }

    public CategoriaForm(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }
}
