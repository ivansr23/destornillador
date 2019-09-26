package com.destornillador.destornillador;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.fasterxml.jackson.core.type.TypeReference;
 
@RunWith(JUnitPlatform.class)
public class TestApplication {
   
    private static Collection<Puntas> parametersToTestAdd() throws IOException {
        List<Puntas> puntasDev = new ArrayList<Puntas>();
        puntasDev = crearListaPuntas();
        return puntasDev;
    }
    @ParameterizedTest
    @MethodSource(names = { "parametersToTestAdd" })
    void tipo2Test(Puntas punta) {
        //// System.out.println(punta);
        //destornillador.cambiarPunta(punta);
        System.out.println(punta);
        //assertThat(punta.getClass().getSimpleName()).isEqualTo(destornillador.tipoDePunta());

    }
    
    public static List<Puntas> crearListaPuntas() throws IOException {
        RecogerDatosJson datos = new RecogerDatosJson();
        List<Puntas> puntas = new ArrayList<Puntas>();
        puntas.add(new Estrella());
        puntas.add(new Plano());
        Collection<Class<?>> clases = new ArrayList<Class<?>>();
        clases.add(Estrella.class);
        clases.add(Plano.class);
        datos.escribirEnJson(puntas, clases);
        TypeReference<List<Puntas>> tipo = new TypeReference<List<Puntas>>() {
        };

        return datos.devolverObjetos(tipo);
    }
}
