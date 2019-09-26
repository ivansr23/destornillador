package com.destornillador.destornillador;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import com.destornillador.destornillador.TestDestornillador.FastTests;
import com.destornillador.destornillador.TestDestornillador.SlowTests;
import com.fasterxml.jackson.core.type.TypeReference;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

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
    public interface FastTests { /* category marker */ }
    public interface SlowTests { /* category marker */ }
    
    @Test
    @Parameters(method = "parametersToTestAdd")
    public void tipoTest(Puntas punta) {
        // System.out.println(punta);
        destornillador.cambiarPunta(punta);
        System.out.println(destornillador.tipoDePunta());
        assertThat(punta.getClass().getSimpleName()).isEqualTo(destornillador.tipoDePunta());
    }

    @Test
    @Parameters(method = "parametersToTestAdd")
    public void mockTest(Puntas punta) {
        // System.out.println(punta);
        destornillador = mock(Destornillador.class);
        destornillador.cambiarPunta(punta);
        destornillador.atornillar();
        destornillador.atornillar();
        verify(destornillador, times(2)).atornillar();
    }

    @Test
    @Parameters(method = "parametersToTestAdd")
    public void whenTest(Puntas punta) {
        // System.out.println(punta);

        destornillador = mock(Destornillador.class);
        destornillador.cambiarPunta(punta);
        when(destornillador.atornillar()).thenReturn("Atornillado");
        assertThat(destornillador.atornillar()).isEqualTo("Atornillado");
    }

    private Collection<Puntas> parametersToTestAdd() throws IOException {
        List<Puntas> puntasDev = new ArrayList<Puntas>();
        puntasDev = crearListaPuntas();
        return puntasDev;
    }

    @Test
    public void noTienePuntaTest() {
        assertThat(destornillador.tipoDePunta()).isNull();
        assertThat(true).isFalse();
    }

    public List<Puntas> crearListaPuntas() throws IOException {
        RecogerDatosJson datos = new RecogerDatosJson();
        List<Puntas> puntas = new ArrayList<Puntas>();
//        puntas.add(new Estrella());
//        puntas.add(new Plano());
        Collection<Class<?>> clases = new ArrayList<Class<?>>();
        clases.add(Estrella.class);
        clases.add(Plano.class);
        datos.escribirEnJson(puntas, clases);
        TypeReference<List<Puntas>> tipo = new TypeReference<List<Puntas>>() {
        };

        return datos.devolverObjetos(tipo);
    }


}