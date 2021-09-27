package br.com.zupacademy.gui.casadocodigo.models;
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
    @NotBlank @Email @Column(nullable = false)
    private String email;
    @NotBlank @Length(max = 400) @Column(nullable = false)
    private String descricao;
    @NotNull @Column(nullable = false)
    private LocalDateTime dataCriacao;

    @Deprecated
    public Autor() {
    }

    public Autor(String nome, String email, String descricao) {
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
