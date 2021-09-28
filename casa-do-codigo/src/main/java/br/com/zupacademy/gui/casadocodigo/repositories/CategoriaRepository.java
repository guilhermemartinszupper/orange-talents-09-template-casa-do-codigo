package br.com.zupacademy.gui.casadocodigo.repositories;

import br.com.zupacademy.gui.casadocodigo.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
