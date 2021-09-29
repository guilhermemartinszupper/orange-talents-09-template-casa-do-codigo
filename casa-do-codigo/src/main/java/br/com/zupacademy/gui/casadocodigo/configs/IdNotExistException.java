package br.com.zupacademy.gui.casadocodigo.configs;

public class IdNotExistException extends RuntimeException{
    public IdNotExistException(String message){
        super(message);
    }
}
