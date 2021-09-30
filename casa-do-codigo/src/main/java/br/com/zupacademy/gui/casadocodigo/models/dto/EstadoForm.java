package br.com.zupacademy.gui.casadocodigo.models.dto;

import br.com.zupacademy.gui.casadocodigo.configs.validators.annotations.IdExist;
import br.com.zupacademy.gui.casadocodigo.configs.validators.annotations.UniqueEstado;
import br.com.zupacademy.gui.casadocodigo.models.Estado;
import br.com.zupacademy.gui.casadocodigo.models.Pais;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@UniqueEstado
public class EstadoForm {
    @NotBlank
    private String nome;
    @IdExist(domainClass = Pais.class) @NotNull
    private Long idPais;

    public EstadoForm(String nome, Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Estado toModel(EntityManager entityManager)
    {
        Pais pais = entityManager.find(Pais.class, this.idPais);
        Assert.isTrue(pais != null, "Pais não pode ser nulo");
        return new Estado(this.nome, pais);
    }
}
