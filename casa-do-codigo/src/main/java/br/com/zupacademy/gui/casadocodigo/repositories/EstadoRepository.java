package br.com.zupacademy.gui.casadocodigo.repositories;

import br.com.zupacademy.gui.casadocodigo.models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    Optional<Estado> findByNomeAndPaisId(String nome, Long paisId);

    Optional<List<Estado>> findAllByPaisId(Long paisId);
}
