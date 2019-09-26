package com.destornillador.destornillador;

public enum Marca {
    BMW(1), AUDI(2), SEAT(3);
    private int id ;
    
    private Marca( int id) {
 
        this.id = id;
 
    }
    @Override
    
    public String toString() {
 
        return String.valueOf ( "El identificador de la marca"+this . id );
 
    }
}


