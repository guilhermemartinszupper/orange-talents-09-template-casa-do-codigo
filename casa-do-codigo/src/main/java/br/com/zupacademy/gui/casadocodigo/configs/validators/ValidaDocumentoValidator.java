package br.com.zupacademy.gui.casadocodigo.configs.validators;

import br.com.zupacademy.gui.casadocodigo.configs.validators.annotations.ValidaDocumento;
import br.com.zupacademy.gui.casadocodigo.utils.ValidadorCPFeCNPJ;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidaDocumentoValidator implements ConstraintValidator<ValidaDocumento, String> {
    @Override
    public void initialize(ValidaDocumento constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String o, ConstraintValidatorContext constraintValidatorContext) {
        return ValidadorCPFeCNPJ.isCNPJ(o) || ValidadorCPFeCNPJ.isCPF(o);
    }
}
