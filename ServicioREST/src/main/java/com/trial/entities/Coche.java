package com.trial.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Coche extends ResourceSupport {
    @NotBlank(message = "no existen coches sin marca")
    @Size(min = 4, max = 20)
    private String marca;
    @NotNull(message = "un coche sin caballos es una bici")
    @Min(75)
    @Max(1000)
    private Integer caballos;
    @NotNull(message = "no puedo entrar al coche sino")
    @Min(3)
    @Max(5)
    private Integer puertas;

    private static Integer ruedas;

    {
        marca = "sin marca";
    }

    static {
        ruedas = 4;
    }
    public String pitar(String pito){
        return  pito;
    }
}
