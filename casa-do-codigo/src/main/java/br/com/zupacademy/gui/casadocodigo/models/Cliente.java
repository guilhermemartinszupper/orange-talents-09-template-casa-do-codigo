package br.com.zupacademy.gui.casadocodigo.models;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Column(nullable = false, unique = true)
    private String email;
    @NotBlank @Column(nullable = false)
    private String nome;
    @NotBlank @Column(nullable = false)
    private String sobrenome;
    @NotBlank @Column(nullable = false)
    private String telefone;
    @NotBlank @Column(nullable = false, unique = true)
    private String documento;
    @NotNull @ManyToOne
    private Pais pais;
    @ManyToOne
    private Estado estado;
    @NotBlank
    private String cep;
    @NotBlank @Column(nullable = false)
    private String endereco;
    @NotBlank @Column(nullable = false)
    private String complemento;
    @NotBlank @Column(nullable = false)
    private String cidade;

    @Deprecated
    public Cliente() {
    }

    public Cliente(String email, String nome, String sobrenome, String telefone, String documento, Pais pais, String cep, String endereco, String complemento, String cidade) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.documento = documento;
        this.pais = pais;
        this.cep = cep;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
    }

    public Cliente(String email, String nome, String sobrenome, String telefone, String documento, Pais pais, Estado estado, String cep, String endereco, String complemento, String cidade) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.documento = documento;
        this.pais = pais;
        this.estado = estado;
        this.cep = cep;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }
}
