package br.com.paulovitor.maisvida.repository;

import br.com.paulovitor.maisvida.model.Endereco;
import br.com.paulovitor.maisvida.model.Medico;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static br.com.paulovitor.maisvida.model.Especialidade.CARDIOLOGISTA;
import static br.com.paulovitor.maisvida.model.Especialidade.PEDIATRA;
import static br.com.paulovitor.maisvida.model.Status.DISPONIVEL;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MedicoRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MedicoRepository repository;

    @Test
    public void deveSalvarMedico() {
        // give
        Medico novo = new Medico("José", "Miguel", CARDIOLOGISTA, "josemiguel@gmail.com", true, DISPONIVEL, new Endereco("DF", "Brasilia"));

        // when
        Medico resultado = repository.save(novo);

        // then
        assertThat(resultado).isNotNull();
        assertThat(resultado.getId()).isNotNull();
    }

    @Test
    public void deveRecuperarPorId() {
        // give
        Medico novo = entityManager.persist(new Medico("Maria", "Cristina", PEDIATRA, "maria@gmail.com", true, DISPONIVEL, new Endereco("DF", "Brasilia")));

        // when
        Medico resultado = repository.findOne(novo.getId());

        // then
        assertThat(resultado).isEqualTo(novo);
    }

    @Test
    public void deveRecuperarTodos() {
        // give
        entityManager.persist(new Medico("Maria", "Cristina", PEDIATRA, "maria@gmail.com", true, DISPONIVEL, new Endereco("DF", "Brasilia")));
        entityManager.persist(new Medico("José", "Miguel", CARDIOLOGISTA, "josemiguel@gmail.com", true, DISPONIVEL, new Endereco("DF", "Brasilia")));

        // when
        Iterable<Medico> medicos = repository.findAll();

        // then
        assertThat(medicos).hasSize(2);
    }
}
