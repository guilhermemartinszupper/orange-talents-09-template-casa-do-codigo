package br.com.zupacademy.gui.casadocodigo.configs.validators;

import br.com.zupacademy.gui.casadocodigo.configs.validators.annotations.UniqueField;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueFieldValidator implements ConstraintValidator<UniqueField, String> {

    @PersistenceContext
    EntityManager entityManager;
    UniqueField uniqueData;


    @Override
    public void initialize(UniqueField constraintAnnotation) {
        this.uniqueData = constraintAnnotation;
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    @Transactional
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        String jpql = "Select m from " + uniqueData.nomeTabela() + " m where " + uniqueData.nomeCampo() + " = '" + s + "'";
        System.out.println(jpql);
        Query query = entityManager.createQuery(jpql);
        List<?> resultList = query.getResultList();
        return resultList.isEmpty();
    }
}
