package com.trial.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CocheDTO {
    private String nombreMarca;
    private Integer ncaballos;
    private Integer npuertas;
}
