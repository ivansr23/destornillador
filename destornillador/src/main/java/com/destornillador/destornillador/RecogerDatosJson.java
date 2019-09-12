package com.destornillador.destornillador;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RecogerDatosJson {
    public String directory = System.getProperty("user.home");
    public String fileName = "puntas.json";
    public String absolutePath = directory + File.separator + fileName;
    public ObjectMapper mapper = new ObjectMapper();
    public File fichero = new File(absolutePath);

    public <T> void escribirEnJson(List<T> objetos, Collection<Class<?>> clases)
            throws JsonGenerationException, JsonMappingException, IOException {
        mapper.registerSubtypes(clases);
        ;
        mapper.writeValue(fichero, objetos);
    }

    public <T> List<T> devolverObjetos(TypeReference<List<T>> tipo)
            throws JsonParseException, JsonMappingException, IOException {
        List<T> objetos = mapper.readValue(fichero, tipo);
        return objetos;
    }

}
