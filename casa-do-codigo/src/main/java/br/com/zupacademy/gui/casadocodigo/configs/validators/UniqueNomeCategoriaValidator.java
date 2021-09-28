package br.com.zupacademy.gui.casadocodigo.configs.validators;

import br.com.zupacademy.gui.casadocodigo.configs.validators.annotations.UniqueNomeCategoria;
import br.com.zupacademy.gui.casadocodigo.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNomeCategoriaValidator implements ConstraintValidator<UniqueNomeCategoria, String> {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public void initialize(UniqueNomeCategoria constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return categoriaRepository.findByNome(s).isEmpty();
    }
}
