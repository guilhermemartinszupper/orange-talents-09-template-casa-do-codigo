package br.com.zupacademy.gui.casadocodigo.configs.validators.annotations;

import br.com.zupacademy.gui.casadocodigo.configs.validators.UniqueEstadoValidator;
import br.com.zupacademy.gui.casadocodigo.models.Pais;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueEstadoValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEstado {
    String message() default "Ja existe um estado com esse nome nesse Pais";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
