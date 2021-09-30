package br.com.zupacademy.gui.casadocodigo.repository;

import br.com.zupacademy.gui.casadocodigo.models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    Optional<Estado> findEstadoByNomeAndPaisId(String nome, Long paisId);
}
