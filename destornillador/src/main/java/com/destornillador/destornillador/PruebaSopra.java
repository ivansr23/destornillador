package com.destornillador.destornillador;

import com.destornillador.destornillador.Puntas.PuntasBuilder;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//COmo hacerllo sin tener constructor??¿?¿?? intentarlo con reflection
@AllArgsConstructor(access= AccessLevel.PRIVATE)
//@NoArgsConstructor(access= AccessLevel.PRIVATE)
@Builder
@Getter
@Setter
public @Data class PruebaSopra {
   private  Integer id;
  
   private final String prueba ;
   private final Integer numero;
    
}
