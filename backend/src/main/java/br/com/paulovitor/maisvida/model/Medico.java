package br.com.paulovitor.maisvida.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Medico implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String primeiroNome;
    private String ultimoNome;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    private String email;
    private boolean ativo;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Endereco endereco;

    public Medico() {
    }

    public Medico(String primeiroNome, String ultimoNome, Especialidade especialidade, String email, boolean ativo, Status status, Endereco endereco) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.especialidade = especialidade;
        this.email = email;
        this.ativo = ativo;
        this.status = status;
        this.endereco = endereco;
    }

    public Integer getId() {
        return id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public Status getStatus() {
        return status;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
