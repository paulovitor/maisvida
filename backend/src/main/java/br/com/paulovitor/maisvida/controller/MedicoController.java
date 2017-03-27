package br.com.paulovitor.maisvida.controller;

import br.com.paulovitor.maisvida.model.Medico;
import br.com.paulovitor.maisvida.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    private MedicoRepository repository;

    @Autowired
    public MedicoController(MedicoRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Medico> list() {
        return repository.findAll();
    }
}
