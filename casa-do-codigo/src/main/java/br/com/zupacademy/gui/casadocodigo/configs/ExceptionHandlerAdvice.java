package br.com.zupacademy.gui.casadocodigo.configs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerAdvice{

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroDTO> handle(MethodArgumentNotValidException exception){
        List<ErroDTO> erros = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(fieldError -> {
            String mensagem = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
            ErroDTO erro = new ErroDTO(fieldError.getField(),mensagem);
            erros.add(erro);
        });
        List<ObjectError> objectErrors = exception.getBindingResult().getGlobalErrors();
        objectErrors.forEach(objectError -> {
            String mensagem = messageSource.getMessage(objectError, LocaleContextHolder.getLocale());
            ErroDTO erro = new ErroDTO(objectError.getObjectName(),mensagem);
            erros.add(erro);
        });
        return erros;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(IdNotExistException.class)
    public ErroDTO handleEntityNotFound(IdNotExistException exception){
        return new ErroDTO("Id",exception.getMessage());
    }

}
