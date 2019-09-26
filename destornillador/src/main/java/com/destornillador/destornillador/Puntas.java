package com.destornillador.destornillador;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;

//@NoArgsConstructor(access = AccessLevel.PRIVATE,force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE, onConstructor = @__(@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)))
@Builder
@Getter
@Value
public class Puntas {
    private final String nombre;
    private final Double dimension;
    private final String materia;

    public static <Z> Z hola(Z objeto) {
        Z hola = objeto;
        return hola;
    }
}
