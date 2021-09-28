package br.com.zupacademy.gui.casadocodigo.configs.validators.annotations;

import br.com.zupacademy.gui.casadocodigo.configs.validators.UniqueEmailValidator;
import br.com.zupacademy.gui.casadocodigo.configs.validators.UniqueNomeCategoriaValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {UniqueNomeCategoriaValidator.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueNomeCategoria {
    String message() default "Ja existe uma Categoria com o nome informado!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
