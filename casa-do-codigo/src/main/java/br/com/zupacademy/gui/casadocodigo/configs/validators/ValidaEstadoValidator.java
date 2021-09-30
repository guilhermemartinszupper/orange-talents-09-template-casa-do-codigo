package br.com.zupacademy.gui.casadocodigo.configs.validators;

import br.com.zupacademy.gui.casadocodigo.configs.validators.annotations.ValidaEstado;
import br.com.zupacademy.gui.casadocodigo.models.Estado;
import br.com.zupacademy.gui.casadocodigo.models.dto.ClienteForm;
import br.com.zupacademy.gui.casadocodigo.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ValidaEstadoValidator implements ConstraintValidator<ValidaEstado,ClienteForm> {

    @Autowired
    EstadoRepository estadoRepository;
    Estado estado = null;
    List<Estado> estadosDoPais = new ArrayList<>();
    String mensagem = "";

    @Override
    public void initialize(ValidaEstado constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(ClienteForm clienteForm, ConstraintValidatorContext constraintValidatorContext) {
       if(possuiEstadoId(clienteForm)){
           constraintValidatorContext.disableDefaultConstraintViolation();
           if(paisPossuiEstados(clienteForm)){
               if(estadoIdValido(clienteForm) ){
                   if(estadoPertenceAoPais()){
                       return true;
                   }
                   constraintValidatorContext.buildConstraintViolationWithTemplate(mensagem).addConstraintViolation();
                   return false;
               }
               constraintValidatorContext.buildConstraintViolationWithTemplate(mensagem).addConstraintViolation();
               return false;
           }
           constraintValidatorContext.buildConstraintViolationWithTemplate(mensagem).addConstraintViolation();
           return false;
       }
       return true;
    }

    private boolean possuiEstadoId(ClienteForm clienteForm){
        return clienteForm.getIdEstado() != null;
    }
    private boolean estadoIdValido(ClienteForm clienteForm){
        Optional<Estado> resultado = estadoRepository.findById(clienteForm.getIdEstado());
        if(resultado.isPresent()){
            estado = resultado.get();
            return true;
        }
        mensagem = "Estado Não Encontrado";
        return false;
    }
    private boolean paisPossuiEstados(ClienteForm clienteForm){
        Optional<List<Estado>> resultado = estadoRepository.findAllByPaisId(clienteForm.getIdPais());
        if(!resultado.get().isEmpty()){
            estadosDoPais = resultado.get();
            return true;
        }
        mensagem = "Esse Pais não Possui Estados";
        return false;
    }
    private boolean estadoPertenceAoPais(){
        if(estadosDoPais.contains(estado)){
            return true;
        }
        mensagem = "Estado não pertence ao pais";
        return false;
    }

}
