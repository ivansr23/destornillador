package com.destornillador.destornillador;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 */
public class App {
    static String directory = System.getProperty("user.home");
    static String fileName = "puntas.json";
    static String absolutePath = directory + File.separator + fileName;
    static File fichero = new File(absolutePath);
    static ObjectMapper mapper = new ObjectMapper();

    static Logger LOG_DESTORNILLADOR = Logger.getLogger("com.destornillador.destornillador.Destornillador");
    static Logger LOG = Logger.getLogger("com.destornillador.destornillador.App");

    static Logger LOG_RAIZ = Logger.getLogger("com.destornillador.destornillador");

    public static void main(String[] args) throws IOException {
        Puntas estrella = new Estrella();
        Puntas plano = new Plano();
        Destornillador<Puntas> prueba = new Destornillador<Puntas>();
        int holi = Destornillador.hola(7);
        String hola = Destornillador.hola("hola");
        System.out.println(holi + hola);
        System.out.println(prueba.desatornillar());
        prueba.cambiarPunta(plano);
        System.out.println(prueba.desatornillar());
        prueba.cambiarPunta(estrella);
        System.out.println(prueba.desatornillar());

        Destornillador<Puntas> punta = new Destornillador();
        Puntas puntaa = Puntas.builder().dimension(3.6).materia("acero").build();
        prueba.cambiarPunta(puntaa);
        Integer holi1 = Destornillador.hola(7);
        String hola1 = Destornillador.hola("hola");
        Puntas estre = Destornillador.hola(estrella);
        System.out.println(estre.getClass().getSimpleName() + hola1.getClass().getSimpleName());

        PruebaHilo hilo1 = PruebaHilo.builder().id(1).build();
        PruebaHilo hilo2 = PruebaHilo.builder().id(2).build();
        hilo1.start();
        hilo2.start();

        Handler consola = new ConsoleHandler();
        LOG_RAIZ.addHandler(consola);
        consola.setLevel(Level.ALL);
        LOG.log(Level.INFO, "CLASE MAIN PROBANDO");
        LOG.log(Level.INFO, "CLASE clase");

        ArrayList<Puntas> puntas = new ArrayList<Puntas>();
        puntas.add(new Estrella());
        puntas.add(new Plano());
        mapper.registerSubtypes(Estrella.class, Plano.class);
        mapper.writeValue(fichero, puntas);

    }
}