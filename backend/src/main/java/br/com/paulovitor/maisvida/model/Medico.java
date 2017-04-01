package br.com.paulovitor.maisvida.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "medico")
public class Medico implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @NotEmpty(message = "{erro.campo.obrigatorio}")
    @Size(min = 3, max = 50, message = "{erro.campo.tamanho}")
    private String primeiroNome;

    @NotEmpty(message = "{erro.campo.obrigatorio}")
    @Size(min = 3, max = 50, message = "{erro.campo.tamanho}")
    private String ultimoNome;

    @NotNull(message = "{erro.campo.obrigatorio}")
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @NotEmpty(message = "{erro.campo.obrigatorio}")
    @Email(message = "{erro.campo.invalido}")
    @Size(min = 5, max = 80, message = "{erro.campo.tamanho}")
    private String email;
    private boolean ativo;

    @NotNull(message = "{erro.campo.obrigatorio}")
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotEmpty(message = "{erro.campo.obrigatorio}")
    @Length(min = 2, max = 20, message = "{erro.campo.tamanho}")
    private String estado;

    @NotEmpty(message = "{erro.campo.obrigatorio}")
    @Length(min = 3, max = 80, message = "{erro.campo.tamanho}")
    private String cidade;

    public Medico() {
    }

    public Medico(String primeiroNome, String ultimoNome, Especialidade especialidade, String email, boolean ativo, Status status, String estado, String cidade) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.especialidade = especialidade;
        this.email = email;
        this.ativo = ativo;
        this.status = status;
        this.estado = estado;
        this.cidade = cidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
