package com.destornillador.destornillador;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class TestDestornillador {
    private static Destornillador<Puntas> destornillador;
    @Rule
    public TestName testName = new TestName();

    @Before
    public void setup() throws Exception {
        System.out.println("Este es el nombre del test '" + testName.getMethodName() + "'");
        destornillador = new Destornillador<Puntas>();
    }

    @Test
    @Parameters(method = "parametersToTestAdd")
    public void tipoTest(Puntas punta) {
    	//System.out.println(punta);
    	destornillador.cambiarPunta(punta);
    	System.out.println(destornillador.tipoDePunta());
    	assertThat(punta.getClass().getSimpleName()).isEqualTo(destornillador.tipoDePunta());
    }
    
    @Test
    @Parameters(method = "parametersToTestAdd")
    public void mockTest(Puntas punta) {
    	//System.out.println(punta);
    	destornillador = mock(Destornillador.class);
    	destornillador.cambiarPunta(punta);
    	destornillador.atornillar();
    	destornillador.atornillar();
    	verify(destornillador, times(2)).atornillar();
    }
    @Test
    @Parameters(method = "parametersToTestAdd")
    public void whenTest(Puntas punta) {
    	//System.out.println(punta);
    	
    	destornillador = mock(Destornillador.class);
    	destornillador.cambiarPunta(punta);
    	when(destornillador.atornillar()).thenReturn("Atornillado");
    	assertThat(destornillador.atornillar()).isEqualTo("Atornillado");
    }
    
    private Collection<Puntas> parametersToTestAdd() throws  IOException  {
    	List<Puntas> puntasDev = new ArrayList<Puntas>();
    	puntasDev= crearListaPuntas();
    	return puntasDev;
    }

    @Test
    public void noTienePuntaTest() {
        assertThat(destornillador.tipoDePunta()).isNull();
    }

    public List<Puntas> crearListaPuntas() throws IOException {
        RecogerDatosJson datos = new RecogerDatosJson();
        List<Puntas> puntas = new ArrayList<Puntas>();
        puntas.add(new Estrella());
        puntas.add(new Plano());
        Collection<Class<?>> clases = new ArrayList<Class<?>>();
        clases.add(Estrella.class);
        clases.add(Plano.class);
        datos.escribirEnJson(puntas,clases);
        TypeReference<List<Puntas>> tipo = new TypeReference<List<Puntas>>() {};
        
        return datos.devolverObjetos(tipo);
    }

}