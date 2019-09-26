package com.destornillador.destornillador;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.platform.commons.util.ReflectionUtils;

import com.destornillador.singleton.ObjSingleton;
import com.destornillador.singleton.Platano;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 */
public class App {
    static String directory = System.getProperty("user.home");
    static String fileName = "puntas.json";
    static String absolutePath = "directory + File.separator + fileName";
    static File fichero = new File(absolutePath);
    static ObjectMapper mapper = new ObjectMapper();

    static Logger LOG_DESTORNILLADOR = Logger.getLogger("com.destornillador.destornillador.Destornillador");
    static Logger LOG = Logger.getLogger("com.destornillador.destornillador.App");

    static Logger LOG_RAIZ = Logger.getLogger("com.destornillador.destornillador");
    static String probar = "eeeee";
    String probar2;
    public static void main(String[] args) throws IOException {
        
        try {
            ExecutorService servicio= Executors.newFixedThreadPool(4);
            Future<Integer> resultado= servicio.submit(new PruebaHilo());
            resultado= servicio.submit(new PruebaHilo());
            resultado= servicio.submit(new PruebaHilo());
            resultado= servicio.submit(new PruebaHilo());
            resultado= servicio.submit(new PruebaHilo());
            resultado= servicio.submit(new PruebaHilo());
            System.out.println("eee"+resultado.isDone());
            if(resultado.isDone()) {
                    System.out.println("ee"+resultado.get());
            }
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        
        
        
        
        
        
        /*Marca holo= Marca.BMW;
        System.out.println(holo);
        Platano platano = ObjSingleton.getSingleton();
        System.out.println(platano.toString());
        Platano platano2 = ObjSingleton.getSingleton();
        
        Platano platano3 = ObjSingleton.getInstance();
        System.out.println(platano3.hashCode());
        Platano platano4 = ObjSingleton.getInstance();
        System.out.println(platano4.hashCode());
        /*RecogerDatosJson datos = new RecogerDatosJson();
        List<PruebaSopra> hola = new ArrayList<PruebaSopra>();
        PruebaSopra prueba = PruebaSopra.builder().id(1).build();
        PruebaSopra prueba2 = PruebaSopra.builder().id(2).build();
        hola.add(prueba);
        hola.add(prueba);
        Collection<Class<?>> clases = new ArrayList<Class<?>>();
        clases.add(PruebaSopra.class);
        datos.escribirEnJson(hola, clases);
        TypeReference<List<Object>> tipo = new TypeReference<List<Object>>() {
        };
        System.out.println(datos.devolverObjetos(tipo));
        */
        
        

        
        
        /*Puntas estrella = new Estrella();
        Puntas plano = new Plano();
        Destornillador<Puntas> prueba = new Destornillador<Puntas>();
        int holi = Destornillador.hola(7);
        String hola = Destornillador.hola("hola");
        System.out.println(holi + hola);
        System.out.println(prueba.desatornillar());
//        prueba.cambiarPunta(plano);
        System.out.println(prueba.desatornillar());
//        prueba.cambiarPunta(estrella);
        System.out.println(prueba.desatornillar());

        Destornillador<Puntas> punta = new Destornillador();
        
        
        PuntasBuilder puntaBuilfrt = Puntas.builder();
        puntaBuilfrt.setMaer
        puntaBuilfrt.setDimens
        puntaBuilfrt.build
        
        .dimension(3.6).materia("acero").build();
        
        
        prueba.cambiarPunta(puntaa);
        Integer holi1 = Destornillador.hola(7);
        String hola1 = Destornillador.hola("hola");
//        Puntas estre = Destornillador.hola(estrella);
//        System.out.println(estre.getClass().getSimpleName() + hola1.getClass().getSimpleName());

        

        Handler consola = new ConsoleHandler();
        LOG_RAIZ.addHandler(consola);
        consola.setLevel(Level.ALL);
        LOG.log(Level.INFO, "CLASE MAIN PROBANDO");
        LOG.log(Level.INFO, "CLASE clase");

        ArrayList<Puntas> puntas = new ArrayList<Puntas>();
//        puntas.add(new Estrella());
//        puntas.add(new Plano());
        mapper.registerSubtypes(Estrella.class, Plano.class);
        mapper.writeValue(fichero, puntas);
    */
    }
}