package br.com.zupacademy.gui.casadocodigo.controllers;

import br.com.zupacademy.gui.casadocodigo.models.Categoria;
import br.com.zupacademy.gui.casadocodigo.models.dto.CategoriaForm;
import br.com.zupacademy.gui.casadocodigo.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping
    public String inserir(@Valid @RequestBody CategoriaForm categoriaForm){
        Categoria categoria = categoriaForm.toModel();
        categoriaRepository.save(categoria);
        return categoria.toString();
    }
}
