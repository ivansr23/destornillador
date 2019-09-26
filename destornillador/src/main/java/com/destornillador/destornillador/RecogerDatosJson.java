package com.destornillador.destornillador;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

class RecogerDatosJson {
    private String directory = System.getProperty("user.home");
    private String fileName = "puntas.json";
    private String absolutePath = directory + File.separator + fileName;
    ObjectMapper mapper = new ObjectMapper();
    private File fichero = new File(absolutePath);

    <T> void escribirEnJson(List<T> objetos, Collection<Class<?>> clases)
            throws JsonGenerationException, JsonMappingException, IOException {
        mapper.registerSubtypes(clases);
        mapper.writeValue(fichero, objetos);
    }

    //patron singleton
    //Evitar tener el TypeReference
    public <T> List<T> devolverObjetos(TypeReference<List<T>> tipo)
            throws JsonParseException, JsonMappingException, IOException {
        List<T> objetos = mapper.readValue(fichero, tipo);
        return objetos;
    }

}
