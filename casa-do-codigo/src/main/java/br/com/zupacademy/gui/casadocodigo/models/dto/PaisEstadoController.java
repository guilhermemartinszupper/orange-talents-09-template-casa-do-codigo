package br.com.zupacademy.gui.casadocodigo.models.dto;

import br.com.zupacademy.gui.casadocodigo.models.Estado;
import br.com.zupacademy.gui.casadocodigo.models.Pais;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/territorios")
public class PaisEstadoController {

    @PersistenceContext
    EntityManager manager;

    @Transactional
    @PostMapping("/pais")
    public String inserirPais(@Valid @RequestBody PaisForm paisForm){
        Pais pais = paisForm.toModel();
        manager.persist(pais);
        return pais.toString();
    }

    @Transactional
    @PostMapping("/estado")
    public String inserirEstado(@Valid @RequestBody EstadoForm estadoForm){
        Estado estado = estadoForm.toModel(manager);
        manager.persist(estado);
        return estado.toString();
    }

}
