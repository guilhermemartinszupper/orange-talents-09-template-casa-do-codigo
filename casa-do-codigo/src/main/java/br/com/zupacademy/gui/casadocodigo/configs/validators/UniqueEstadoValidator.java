package br.com.zupacademy.gui.casadocodigo.configs.validators;

import br.com.zupacademy.gui.casadocodigo.configs.validators.annotations.UniqueEstado;
import br.com.zupacademy.gui.casadocodigo.models.Estado;
import br.com.zupacademy.gui.casadocodigo.models.dto.EstadoForm;
import br.com.zupacademy.gui.casadocodigo.models.dto.PaisForm;
import br.com.zupacademy.gui.casadocodigo.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.Optional;

public class UniqueEstadoValidator implements ConstraintValidator<UniqueEstado, EstadoForm> {

    @Autowired
    EstadoRepository estadoRepository;

    @Override
    public void initialize(UniqueEstado constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(EstadoForm s, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Estado> estado = estadoRepository.findEstadoByNomeAndPaisId(s.getNome(),s.getIdPais());
        return estado.isEmpty();
    }

}
