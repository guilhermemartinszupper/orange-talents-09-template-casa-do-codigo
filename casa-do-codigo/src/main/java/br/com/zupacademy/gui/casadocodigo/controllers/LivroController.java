package br.com.zupacademy.gui.casadocodigo.controllers;

import br.com.zupacademy.gui.casadocodigo.configs.IdNotExistException;
import br.com.zupacademy.gui.casadocodigo.models.Livro;
import br.com.zupacademy.gui.casadocodigo.models.dto.LivroDTO;
import br.com.zupacademy.gui.casadocodigo.models.dto.LivroDetalhadoDTO;
import br.com.zupacademy.gui.casadocodigo.models.dto.LivroForm;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("{id}")
    public LivroDetalhadoDTO detalhar(@PathVariable Long id){
        Optional <Livro> livro = Optional.ofNullable(entityManager.find(Livro.class, id));
        if(livro.isEmpty()){
            throw new IdNotExistException("Id Não Encontrado");
        }
        return new LivroDetalhadoDTO(livro.get());
    }
    @PostMapping
    @Transactional
    public String inserir(@RequestBody @Valid LivroForm livroForm){
        Livro livro = livroForm.converter(entityManager);
        entityManager.persist(livro);
        return livro.toString();
    }
}
