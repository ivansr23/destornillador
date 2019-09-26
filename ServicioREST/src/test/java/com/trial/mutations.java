package com.trial;

import com.trial.entities.Coche;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class mutations {
    @Test
    public void mutar(){
        Coche coche = new Coche("mercedes",150,5);
    }
}
