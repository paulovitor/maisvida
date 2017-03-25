package br.com.paulovitor.maisvida.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Endereco {

    @Id
    @GeneratedValue
    private Integer id;
    private String estado;
    private String cidade;

    public Endereco() {
    }

    public Endereco(String estado, String cidade) {
        this.estado = estado;
        this.cidade = cidade;
    }

    public Integer getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }
}
