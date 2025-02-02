package br.com.zupacademy.gui.casadocodigo.configs.validators.annotations;

import br.com.zupacademy.gui.casadocodigo.configs.validators.ValidaEstadoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidaEstadoValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidaEstado {
    String message() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
