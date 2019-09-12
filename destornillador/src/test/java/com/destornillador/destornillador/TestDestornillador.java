package com.destornillador.destornillador;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Before;
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
    @Rule
    public   TestName testName = new TestName();


    @Before
    public  void setup() throws Exception {
        System.out.println("Este es el nombre del test '" + testName.getMethodName() + "'");
        destornillador = new Destornillador<Puntas>();
    }

    @Test
    @Parameters(method = "parametersToTestAdd")
    public void tipoTest(List<Integer> puntas) {
    	System.out.println(puntas);
        //destornillador.cambiarPunta(punta);
        //assertThat(destornillador.tipoDePunta()).isEqualTo("Estrella");
    }

    private Object[] parametersToTestAdd() throws IOException {
       
        List<Puntas> puntas = new ArrayList<Puntas>();
        
       // Puntas punta = new Estrella();
        //Puntas punta2 = new Estrella();
        puntas.add(new Estrella());
        puntas.add(new Plano());
        String directory = System.getProperty("user.home");
        String fileName = "puntas.json";
        String absolutePath = directory + File.separator + fileName;

        ObjectMapper mapper = new ObjectMapper();
        File fichero = new File(absolutePath);

    
        
        mapper.registerSubtypes(Estrella.class, Plano.class);
        mapper.writeValue(fichero, puntas);

        List<Puntas> o = mapper.readValue(fichero, new TypeReference<List<Puntas>>() {
        });
        //List<Puntas> puntas = App.mapper.readValue(App.fichero,new TypeReference<List<Puntas>>() {});
        return new Object[] {
                o
        };
    }

    @Test
    public void noTienePuntaTest() {
        assertThat(destornillador.tipoDePunta()).isNull();
    }

}