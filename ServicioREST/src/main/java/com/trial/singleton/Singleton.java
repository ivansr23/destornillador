package com.trial.singleton;

public class Singleton {
    private static volatile Singleton INSTANCE;

    private Singleton() {
    }

    //synchronized por si hay muchos hilos que quieren acceder al singleton
    //evitamos que mas de un hilo cree instancias
    public static Singleton getInstance() {
        if ( INSTANCE == null)
            synchronized (Singleton.class) {
                if (INSTANCE == null)
                    INSTANCE = new Singleton();
            }
        return INSTANCE;
    }
}
