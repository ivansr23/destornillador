package com.trial.entities;

import lombok.AllArgsConstructor;
import lombok.Value;
@AllArgsConstructor
@Value
public class Persona {
    private String nombre;
    private String apellido;
    private String dni;
}
