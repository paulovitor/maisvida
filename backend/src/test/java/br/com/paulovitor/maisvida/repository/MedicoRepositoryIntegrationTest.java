package br.com.paulovitor.maisvida.repository;

import br.com.paulovitor.maisvida.model.Endereco;
import br.com.paulovitor.maisvida.model.Especialidade;
import br.com.paulovitor.maisvida.model.Medico;
import br.com.paulovitor.maisvida.model.Status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MedicoRepositoryIntegrationTest {

    @Autowired
    private MedicoRepository repository;

    @Test
    public void deveSalvarMedico() {
        // give
        Medico medico = new Medico("José", "Miguel", Especialidade.CARDIOLOGISTA, "josemiguel@gmail.com", true, Status.DISPONIVEL, new Endereco("DF", "Brasilia"));

        // when
        Medico salvo = repository.save(medico);

        // then
        assertNotNull(salvo);
        assertNotNull(salvo.getId());
    }
}
