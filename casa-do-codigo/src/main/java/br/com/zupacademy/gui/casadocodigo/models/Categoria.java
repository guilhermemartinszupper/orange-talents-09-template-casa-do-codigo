package br.com.zupacademy.gui.casadocodigo.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Column(unique = true)
    private String nome;

    @Deprecated
    public Categoria() {
    }

    public String getNome() {
        return nome;
    }

    public Categoria(String nome) {
        this.nome = nome;
    }
    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
