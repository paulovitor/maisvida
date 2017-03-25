package br.com.paulovitor.maisvida.repository;

import br.com.paulovitor.maisvida.model.Medico;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MedicoRepository extends PagingAndSortingRepository<Medico, Integer> {
}
