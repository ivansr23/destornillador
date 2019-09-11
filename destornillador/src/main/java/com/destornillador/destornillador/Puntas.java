package com.destornillador.destornillador;

public class Puntas {
    protected Double dimension;
    protected String materia;

    public Puntas(Double dimension, String materia) {
        super();
        this.dimension = dimension;
        this.materia = materia;
    }

    public Double getDimension() {
        return dimension;
    }

    public void setDimension(Double dimension) {
        this.dimension = dimension;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    ;

}
