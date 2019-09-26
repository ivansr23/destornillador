package com.destornillador.destornillador;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Junit5Test {
    public Junit5Test() throws IOException {
    }

    @Test
    public void algoTest() throws IOException {
        Puntas uno = Puntas.builder().nombre("plano").dimension(2.5).materia("acero").build();
        Puntas dos = Puntas.builder().nombre("estrellita").dimension(2.5).materia("acero").build();
        RecogerDatosJson recogerDatosJson = new RecogerDatosJson();
        recogerDatosJson.escribirEnJson(Arrays.asList(uno, dos), Arrays.<Class<?>>asList(Puntas.class));
        SimpleModule modulo = new SimpleModule();
        modulo.addDeserializer(Puntas.class, new PuntasDeserializer());
        recogerDatosJson.mapper.registerModule(modulo);
        List<Puntas> puntas = recogerDatosJson.devolverObjetos(new TypeReference<List<Puntas>>() {
        });

        System.out.println(puntas);
        assertEquals(puntas.get(0), uno);
    }

    //    So, this example shows us two things we need for a parameterized test:
    //
    //    a source of arguments, an int array, in this case
    //    a way to access them, in this case, the number parameter
    @ParameterizedTest
    @CsvSource({ "Puntas,2.5,aceropuro" })
    void fullName_ShouldGenerateTheExpectedFullName(ArgumentsAccessor argumentsAccessor) {
        Puntas punta = Puntas.builder().nombre(argumentsAccessor.getString(0)).materia(argumentsAccessor.getString(2))
                .dimension(argumentsAccessor.getDouble(1)).build();

        assertEquals(punta.getClass().getSimpleName(), "Puntas");
    }

    @ParameterizedTest
    @CsvFileSource(resources = { "data.csv" }, delimiter = ',')
    void isOdd_ShouldReturnTrueForOddNumbers(Puntas punta) throws IOException {
        Puntas punta1 = Puntas.builder().dimension(2.5).materia("aceropuro").build();
        //
        //        String json = new ObjectMapper().writeValueAsString(punta);
        //        Puntas recuperado = new ObjectMapper().readValue(new File(
        //                        "C:\\Users\\shiznicenco\\Documents\\workspace-spring-tool-suite-4-4.3.1.RELEASE\\destornillador\\destornillador\\src\\test\\java\\com\\destornillador\\destornillador\\data.csv"),
        //                Puntas.class);
        System.out.println(punta);

        //    }
        //    ObjectMapper objeto = new ObjectMapper();
        //        objeto.configure(JsonGenerator.Feature.IGNORE_UNKNOWN,true);
        //    // initialize the schema
        //    CsvSchema schema = CsvSchema.builder().addColumn("nombre").addColumn("dimension").addColumn("materia").build();
        //
        //    // map the bean with our schema for the writer
        //    ObjectWriter writer = new CsvMapper().writerFor(Puntas.class).with(schema);
        //
        //    File tempFile = new File("C:\\Users\\shiznicenco\\Documents\\workspace-spring-tool-suite-4-4.3.1.RELEASE\\destornillador\\destornillador\\src\\test\\java\\com\\destornillador\\destornillador\\data.csv");
        //    // we write the list of objects
        //        writer.writeValues(tempFile).write(punta);

    }
}
