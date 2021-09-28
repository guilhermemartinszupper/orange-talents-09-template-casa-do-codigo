package br.com.zupacademy.gui.casadocodigo.models.dto;

import br.com.zupacademy.gui.casadocodigo.configs.validators.annotations.UniqueField;
import br.com.zupacademy.gui.casadocodigo.models.Autor;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AutorForm {
    @NotBlank
    private String nome;
    @NotBlank @Email @UniqueField(nomeTabela = "Autor",nomeCampo = "email")
    private String email;
    @NotBlank @Length(max = 400)
    private String descricao;

    public AutorForm(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getEmail() {
        return email;
    }

    public Autor converter(){
        return new Autor(this.nome,this.email,this.descricao);
    }
}
