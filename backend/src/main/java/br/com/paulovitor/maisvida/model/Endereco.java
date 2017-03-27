package br.com.paulovitor.maisvida.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue
    private Integer id;

    @NotEmpty(message = "{erro.campo.obrigatorio}")
    @Length(min = 2, max = 20, message = "{erro.campo.tamanho}")
    private String estado;

    @NotEmpty(message = "{erro.campo.obrigatorio}")
    @Length(min = 3, max = 80, message = "{erro.campo.tamanho}")
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
