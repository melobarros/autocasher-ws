package com.registros.autocasher.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("A")
@JsonTypeName("abastecimento")
public class Abastecimento extends Registro{
    private static final long serialVersionUID = 1L;
    
    private float odometro;
    private float precoLitro;
    private float valorTotal;
    private float litros;
    private boolean completandoTanque;
    private boolean abastecimentoAnteriorEmFalta;
    
    
    public float getOdometro() {
        return odometro;
    }

    public void setOdometro(float odometro) {
        this.odometro = odometro;
    }

    public float getPrecoLitro() {
        return precoLitro;
    }

    public void setPrecoLitro(float precoLitro) {
        this.precoLitro = precoLitro;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public float getLitros() {
        return litros;
    }

    public void setLitros(float litros) {
        this.litros = litros;
    }

    public boolean isCompletandoTanque() {
        return completandoTanque;
    }

    public void setCompletandoTanque(boolean completandoTanque) {
        this.completandoTanque = completandoTanque;
    }

    public boolean isAbastecimentoAnteriorEmFalta() {
        return abastecimentoAnteriorEmFalta;
    }

    public void setAbastecimentoAnteriorEmFalta(boolean abastecimentoAnteriorEmFalta) {
        this.abastecimentoAnteriorEmFalta = abastecimentoAnteriorEmFalta;
    }
    
    
    
}
