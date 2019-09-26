package com.trial.entities;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class Propietario {
    private String nombreCompleto;
    private String coche;
}
