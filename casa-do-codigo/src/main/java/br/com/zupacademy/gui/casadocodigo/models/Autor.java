package br.com.zupacademy.gui.casadocodigo.models;
import br.com.zupacademy.gui.casadocodigo.configs.validators.annotations.UniqueEmail;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Autor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Column(nullable = false)
    private String nome;
    @NotBlank @Email @Column(nullable = false,unique = true)
    private String email;
    @NotBlank @Length(max = 400) @Column(nullable = false)
    private String descricao;
    @NotNull @Column(nullable = false)
    private LocalDateTime dataCriacao;

    @Deprecated
    public Autor() {
    }

    public Autor(String nome, String email, String descricao) {
        System.out.println("Construindo Autor");
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.dataCriacao = LocalDateTime.now();
    }


    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}
