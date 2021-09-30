package br.com.zupacademy.gui.casadocodigo.repositories;

import br.com.zupacademy.gui.casadocodigo.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
