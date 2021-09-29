package br.com.zupacademy.gui.casadocodigo.controllers;

import br.com.zupacademy.gui.casadocodigo.models.Livro;
import br.com.zupacademy.gui.casadocodigo.models.dto.LivroForm;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public String inserir(@RequestBody @Valid LivroForm livroForm){
        System.out.println(livroForm.toString());
        Livro livro = livroForm.converter(entityManager);
        entityManager.persist(livro);
        return livro.toString();
    }
}
