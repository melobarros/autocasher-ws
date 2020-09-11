package com.registros.autocasher.models;

import com.fasterxml.jackson.annotation.JsonTypeName;
import javax.persistence.Entity;

@Entity
@JsonTypeName("lembrete")
public class Lembrete extends Registro {
    private static final long serialVersionUID = 1L;
    
    private String descricao;
    private int repetirCada;
    private float valorPrevisto;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getRepetirCada() {
        return repetirCada;
    }

    public void setRepetirCada(int repetirCada) {
        this.repetirCada = repetirCada;
    }

    public float getValorPrevisto() {
        return valorPrevisto;
    }

    public void setValorPrevisto(float valorPrevisto) {
        this.valorPrevisto = valorPrevisto;
    }
}
