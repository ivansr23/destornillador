package com.destornillador.destornillador;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PuntasDeserializer extends StdDeserializer<Puntas> {

    public PuntasDeserializer() {
        this(null);
    }


    public PuntasDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Puntas deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        String nombre = node.get("nombre").asText();
        Double dimension = node.get("dimension").asDouble();
        String materia = node.get("materia").asText();
        Constructor<Puntas> constructor = null;
        try {
             constructor = Puntas.class.getDeclaredConstructor(String.class, Double.class, String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println(constructor);
        constructor.setAccessible(true);
        Puntas punta = null;
        try {
            punta =  constructor.newInstance(nombre, dimension, materia);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(punta);

        return punta;
    }
}