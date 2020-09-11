package com.registros.autocasher.models;


import com.fasterxml.jackson.annotation.JsonTypeName;
import javax.persistence.Entity;

@Entity
@JsonTypeName("manutencao")
public class Manutencao extends Registro {
    private static final long serialVersionUID = 1L;
    
    private String descricao;
    private float valor;
    private String pecas;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getPecas() {
        return pecas;
    }

    public void setPecas(String pecas) {
        this.pecas = pecas;
    }
    
    
}
