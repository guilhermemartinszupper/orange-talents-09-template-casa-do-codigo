package br.com.zupacademy.gui.casadocodigo.configs.validators.annotations;

import br.com.zupacademy.gui.casadocodigo.configs.validators.ValidaDocumentoValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidaDocumentoValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidaDocumento {
    String message() default "CPF ou CPNJ Invalido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
