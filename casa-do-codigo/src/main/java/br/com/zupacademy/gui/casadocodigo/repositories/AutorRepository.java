package br.com.zupacademy.gui.casadocodigo.repositories;

import br.com.zupacademy.gui.casadocodigo.models.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {
}
