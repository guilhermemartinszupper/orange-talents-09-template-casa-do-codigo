package br.com.zupacademy.gui.casadocodigo.models.dto;

import br.com.zupacademy.gui.casadocodigo.configs.validators.annotations.UniqueEstado;
import br.com.zupacademy.gui.casadocodigo.configs.validators.annotations.UniqueField;
import br.com.zupacademy.gui.casadocodigo.models.Pais;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;


public class PaisForm {

    @NotBlank
    @UniqueField(domainClass = Pais.class,nomeCampo = "nome")
    public String nome;

    @Deprecated
    public PaisForm() {
    }

    public PaisForm(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pais toModel() {
        return new Pais(this.nome);
    }
}
