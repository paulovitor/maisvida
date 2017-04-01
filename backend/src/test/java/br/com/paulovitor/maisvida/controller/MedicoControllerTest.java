package br.com.paulovitor.maisvida.controller;

import br.com.paulovitor.maisvida.model.Medico;
import br.com.paulovitor.maisvida.repository.MedicoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static br.com.paulovitor.maisvida.model.Especialidade.CARDIOLOGISTA;
import static br.com.paulovitor.maisvida.model.Status.DISPONIVEL;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MedicoController.class)
public class MedicoControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MedicoRepository medicoRepository;
    private Medico medico;

    @Before
    public void inicializa() {
        medico = new Medico("José", "Miguel", CARDIOLOGISTA, "josemiguel@gmail.com", true, DISPONIVEL, "DF", "Brasilia");
    }

    @Test
    public void deveListarTodos() throws Exception {
        List<Medico> medicos = Arrays.asList(medico);

        when(medicoRepository.findAll()).thenReturn(medicos);

        mvc.perform(get("/api/medicos").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].primeiroNome", is(medico.getPrimeiroNome())))
                .andExpect(content().json("[{\"id\":null,\"primeiroNome\":\"José\",\"ultimoNome\":\"Miguel\",\"especialidade\":\"CARDIOLOGISTA\",\"email\":\"josemiguel@gmail.com\",\"ativo\":true,\"status\":\"DISPONIVEL\",\"estado\":\"DF\",\"cidade\":\"Brasilia\"}]"));
    }

    @Test
    public void deveAdicionarMedico() throws Exception {
        when(medicoRepository.save(any(Medico.class))).thenReturn(medico);

        mvc.perform(post("/api/medicos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(medico)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(medico.getId())));
    }

    @Test
    public void naoDeveAdicionarMedicoSemCamposObrigatorios() throws Exception {
        Medico medico = new Medico(null, "Miguel", null, "josemiguel@gmail.com", true, DISPONIVEL, "DF", "Brasilia");

        mvc.perform(post("/api/medicos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(medico)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void deveRecuperarMedicoPorId() throws Exception {
        when(medicoRepository.findOne(1)).thenReturn(medico);

        mvc.perform(get("/api/medicos/{id}", 1).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.primeiroNome", is(medico.getPrimeiroNome())));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
