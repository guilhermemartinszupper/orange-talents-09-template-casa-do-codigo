package br.com.zupacademy.gui.casadocodigo.repository;

import br.com.zupacademy.gui.casadocodigo.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
