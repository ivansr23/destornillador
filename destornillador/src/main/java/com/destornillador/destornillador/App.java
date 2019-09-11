package com.destornillador.destornillador;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Puntas estrella = new Estrella(null, null);
    	Puntas plano = new Plano(null, null);
        Destornillador<Puntas> prueba = new Destornillador<Puntas>();
        System.out.println(prueba.desatornillar());
        prueba.cambiarPunta(plano);
        System.out.println(prueba.desatornillar());
        prueba.cambiarPunta(estrella);
        System.out.println(prueba.desatornillar());
        
        
    }
}