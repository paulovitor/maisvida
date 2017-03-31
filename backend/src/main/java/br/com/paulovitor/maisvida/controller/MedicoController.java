package br.com.paulovitor.maisvida.controller;

import br.com.paulovitor.maisvida.model.Medico;
import br.com.paulovitor.maisvida.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    private MedicoRepository medicoRepository;

    @Autowired
    public MedicoController(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Medico> list() {
        return medicoRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Medico create(@RequestBody @Valid Medico medico) {
        return medicoRepository.save(medico);
    }
}
