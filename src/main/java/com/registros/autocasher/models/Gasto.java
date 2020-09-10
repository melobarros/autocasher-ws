package com.registros.autocasher.models;

import com.fasterxml.jackson.annotation.JsonTypeName;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("G")
@JsonTypeName("gasto")
public class Gasto extends Registro {
    private static final long serialVersionUID = 1L;
    
    private float odometro;
    private String motivo;
    private float valorTotal;

    public float getOdometro() {
        return odometro;
    }

    public void setOdometro(float odometro) {
        this.odometro = odometro;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
}
