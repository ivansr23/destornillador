package com.destornillador.singleton;

public class ObjSingleton {
    private static Platano platano;
    private static final Platano platano2 =  new Platano("madurito", 200);
    
    public static Platano getSingleton() {
        if(platano==null) {
            platano = new Platano("hola", 100);
        }
        else {
            System.out.println("Ya esta creado platano");
        }
        return platano;
    }
    
   
    
    public static Platano getInstance() {
        return platano2;
    }

    /** Provide a global point of access to the instance */
  
    

}
