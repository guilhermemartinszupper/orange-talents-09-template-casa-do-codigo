package br.com.zupacademy.gui.casadocodigo.configs.validators.annotations;



import br.com.zupacademy.gui.casadocodigo.configs.validators.UniqueEmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Constraint(validatedBy = {UniqueEmailValidator.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {
    String message() default "Já existe um(a) autor(a) com o email informado!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
