package com.destornillador.destornillador;

public class Destornillador<T> {
    private T punta;

    public Destornillador() {
        this.punta = null;
    }

    public void cambiarPunta(T t) {
        if (t instanceof Puntas)
            this.punta = t;
        else
            System.out.println("No es un tipo Punta..");
    }

    public String desatornillar() {
        if( punta != null)
            return punta.getClass().getSimpleName() + " estoy desatornillando";
        return "No tengo punta";
    }

    public String atornillar() {
        if( punta != null)
            return punta.getClass().getSimpleName() + " estoy atornillando";
        return "No tengo punta";
    }

    public String tipoDePunta() {
    	if(punta != null)
    		return punta.getClass().getSimpleName();
    	return null;
    }
}
