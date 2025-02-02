package br.com.zupacademy.gui.casadocodigo.models;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @NotBlank @Column(unique = true,nullable = false)
    public String nome;

    @Deprecated
    public Pais() {
    }

    public Pais(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
