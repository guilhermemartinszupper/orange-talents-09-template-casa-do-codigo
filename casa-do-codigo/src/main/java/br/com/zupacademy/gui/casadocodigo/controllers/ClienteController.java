package br.com.zupacademy.gui.casadocodigo.controllers;

import br.com.zupacademy.gui.casadocodigo.models.Cliente;
import br.com.zupacademy.gui.casadocodigo.models.dto.ClienteForm;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RequestMapping("/clientes")
@RestController
public class ClienteController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public String inserirCliente(@Valid @RequestBody ClienteForm clienteForm){
        Cliente cliente = clienteForm.toModel(entityManager);
        entityManager.persist(cliente);
        return cliente.getId().toString();
    }
}
