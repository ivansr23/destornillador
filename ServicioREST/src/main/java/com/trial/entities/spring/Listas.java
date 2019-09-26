package com.trial.entities.spring;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class Listas {
    @Autowired
    ComponenteUno c1;
    @Autowired
    ComponenteDos c2;

    public Listas(){
        ArrayList<Interfaz> lista = new ArrayList<>();
        lista.add(c1);
        lista.add(c2);
    }
}

