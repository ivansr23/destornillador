package com.destornillador.destornillador;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, //field must be present in the POJO
        property = "nombre")
public @Data class Puntas {
    @JsonProperty
    protected String nombre = this.getClass().getSimpleName();
    @JsonProperty
    private Double dimension;
    @JsonProperty
    private String materia;

    public static <Z> Z hola(Z objeto) {
        Z hola = objeto;
        return hola;
    }
}
