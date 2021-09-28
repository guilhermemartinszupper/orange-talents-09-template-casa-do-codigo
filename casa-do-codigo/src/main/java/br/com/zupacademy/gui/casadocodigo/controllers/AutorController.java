package br.com.zupacademy.gui.casadocodigo.controllers;
import br.com.zupacademy.gui.casadocodigo.models.Autor;
import br.com.zupacademy.gui.casadocodigo.models.dto.AutorForm;
import br.com.zupacademy.gui.casadocodigo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;


@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    @PostMapping
    public String inserir(@RequestBody @Valid AutorForm autorForm){
        Autor autor = autorForm.converter();
        autorRepository.save(autor);
        return autor.toString();
    }
}
