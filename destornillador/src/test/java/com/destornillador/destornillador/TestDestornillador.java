package com.destornillador.destornillador;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class TestDestornillador {
	private Destornillador<Puntas> destornillador;

    @Rule
    public final TestName testName = new TestName();
    
    @Before
    public void setup() throws Exception {
        System.out.println("Este es el nombre del test '" + testName.getMethodName() + "'");
         destornillador = new Destornillador<Puntas>();
    }
    
    @Test
    public void esEstrellaTest() {
    	Puntas estrella = new Estrella(null, null);
        destornillador.cambiarPunta(estrella);
        assertThat(destornillador.tipoDePunta()).isEqualTo("Estrella");
    }
    
    @Test
    public void esPlanoTest() {
    	Puntas plano = new Plano(null, null);
        destornillador.cambiarPunta(plano);
        assertThat(destornillador.tipoDePunta()).isEqualTo("Plano");
    }
    @Test
    public void noTienePuntaTest() { 
        assertThat(destornillador.tipoDePunta()).isNull();
    }
    
}