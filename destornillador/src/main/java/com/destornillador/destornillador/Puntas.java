package com.destornillador.destornillador;

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
