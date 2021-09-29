package br.com.zupacademy.gui.casadocodigo.controllers;

import br.com.zupacademy.gui.casadocodigo.models.Livro;
import br.com.zupacademy.gui.casadocodigo.models.dto.LivroDTO;
import br.com.zupacademy.gui.casadocodigo.models.dto.LivroForm;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @PersistenceContext
    EntityManager entityManager;

    @GetMapping
    public List<LivroDTO> listar(){
        TypedQuery<Livro> query = entityManager.createQuery("Select l from Livro l",Livro.class);
        List<Livro> resultList = query.getResultList();
        return LivroDTO.converterListaLivros(resultList);
    }

    @PostMapping
    @Transactional
    public String inserir(@RequestBody @Valid LivroForm livroForm){
        Livro livro = livroForm.converter(entityManager);
        entityManager.persist(livro);
        return livro.toString();
    }
}
