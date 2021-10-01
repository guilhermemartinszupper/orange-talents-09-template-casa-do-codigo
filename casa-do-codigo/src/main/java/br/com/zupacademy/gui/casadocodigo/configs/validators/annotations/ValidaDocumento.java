package br.com.zupacademy.gui.casadocodigo.configs.validators.annotations;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.*;

@Documented
@ConstraintComposition(CompositionType.OR)
@CPF
@ReportAsSingleViolation
@CNPJ
@Constraint(validatedBy = {})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidaDocumento {
    String message() default "CPF ou CPNJ Invalido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
