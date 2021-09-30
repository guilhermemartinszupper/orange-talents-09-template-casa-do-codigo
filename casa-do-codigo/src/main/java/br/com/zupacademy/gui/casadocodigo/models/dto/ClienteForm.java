package br.com.zupacademy.gui.casadocodigo.models.dto;

import br.com.zupacademy.gui.casadocodigo.configs.IdNotExistException;
import br.com.zupacademy.gui.casadocodigo.configs.validators.annotations.IdExist;
import br.com.zupacademy.gui.casadocodigo.configs.validators.annotations.UniqueField;
import br.com.zupacademy.gui.casadocodigo.configs.validators.annotations.ValidaDocumento;
import br.com.zupacademy.gui.casadocodigo.configs.validators.annotations.ValidaEstado;
import br.com.zupacademy.gui.casadocodigo.models.Cliente;
import br.com.zupacademy.gui.casadocodigo.models.Estado;
import br.com.zupacademy.gui.casadocodigo.models.Pais;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@ValidaEstado
public class ClienteForm {
    @NotBlank @UniqueField(domainClass = Cliente.class,nomeCampo = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String telefone;
    @ValidaDocumento @NotBlank @UniqueField(domainClass = Cliente.class, nomeCampo = "documento")
    private String documento;
    @NotNull @IdExist(domainClass = Pais.class)
    private Long idPais;
    private Long idEstado;
    @NotBlank
    private String cep;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;

    @Deprecated
    public ClienteForm() {
    }

    public ClienteForm(String email, String nome, String sobrenome, String telefone, String documento, Long idPais, Long idEstado, String cep, String endereco, String complemento, String cidade) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.documento = documento;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.cep = cep;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getDocumento() {
        return documento;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public String getCep() {
        return cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Cliente toModel(EntityManager entityManager) {
        Assert.isTrue(idPais != null, "Pais é Obrigatorio");
        Optional<Pais> pais = Optional.ofNullable(entityManager.find(Pais.class,this.idPais));
        Optional<Estado> estado = Optional.empty();
        if(idEstado != null){
            estado = Optional.ofNullable(entityManager.find(Estado.class, this.idEstado));
        }
        if(estado.isPresent() && pais.isPresent()){
            return new Cliente(this.email,this.nome,this.sobrenome,this.telefone,this.documento, pais.get(), estado.get(),this.cep,this.endereco,this.complemento,this.cidade);

        }else if(pais.isPresent()){
            return new Cliente(this.email,this.nome,this.sobrenome,this.telefone,this.documento, pais.get(),this.cep,this.endereco,this.complemento,this.cidade);
        }else{
            throw new IdNotExistException("ID do Pais não encontrado");
        }
    }
}
