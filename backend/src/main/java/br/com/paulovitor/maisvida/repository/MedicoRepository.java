package br.com.paulovitor.maisvida.repository;

import br.com.paulovitor.maisvida.model.Medico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MedicoRepository extends CrudRepository<Medico, Integer> {

    @Override
    List<Medico> findAll();
}
