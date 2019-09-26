package com.destornillador.singleton;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public @Data class Platano {
    private String madurez;
    private int peso;
    
}
