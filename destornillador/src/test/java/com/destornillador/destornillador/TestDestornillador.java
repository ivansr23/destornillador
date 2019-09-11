package com.destornillador.destornillador;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(JUnitParamsRunner.class)
public class TestDestornillador {
    private static Destornillador<Puntas> destornillador;
    @ClassRule
    public static final TestName testName = new TestName();


    @BeforeClass
    public static void setup() throws Exception {
        System.out.println("Este es el nombre del test '" + testName.getMethodName() + "'");
        destornillador = new Destornillador<Puntas>();
    }

    @Test
    @Parameters(method = "parametersToTestAdd")
    public void tipoTest(Puntas punta) {
        destornillador.cambiarPunta(punta);
        assertThat(destornillador.tipoDePunta()).isEqualTo("Plano");
    }

    private Object[] parametersToTestAdd() throws IOException {
        List<Puntas> puntas = App.mapper.readValue(App.fichero,new TypeReference<List<Puntas>>() {
        });
        return new Object[] {
                new Object[] { puntas }
        };
    }

    @Test
    public void noTienePuntaTest() {
        assertThat(destornillador.tipoDePunta()).isNull();
    }

}