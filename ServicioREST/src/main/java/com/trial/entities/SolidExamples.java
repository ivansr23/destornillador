package com.trial.entities;

import java.util.ArrayList;

public class SolidExamples {
    static class Juguete{
        ArrayList<Juguete> juguetes = new ArrayList<>();
        public String tipo;

        Juguete() {
        }
        //Cambiar las clases pq no tiene responsabilidad unica,hacer una clase que guarde juguetes
        private void guardarJuguete(){
            juguetes.add(this);
        }

        //open close princple, si se añade un tipo de juguete habria que modificar la clase.
        //se suele  hacer con herencia o interfaces     asi no afecta a la aplicacoin que ya tenemos    (open for extension)
        public void imprimir(){
            juguetes.forEach((x) -> {
                if(x.tipo == "1")
                    System.out.println("es  un coche");
                else if (x.tipo == "2")
                    System.out.println("es una casa");
            });

        }
    }
            //Interface segregation
            //implementar solo metodos que nos interesan no todos.
    private interface  Manejador{
        void guardar();
        void modificar();
        void vender();
    }
    private interface  Guarda{
        void guardar();
    }
    private interface Modifica{
        void moficiar();
    }
    private interface Vende{
        void vender();
    }
    private Vehiculo coche;
    private Juguetes juguete;
    public SolidExamples(Vehiculo coche,Juguetes juguete){
        this.coche = coche;
        this.juguete = juguete;
    }
    // ahora estaria desacoplada asi po'demos cambiar en cualquier momento el tipo de cada una solo jugando con la interfaz
    private interface Juguetes{}
    private interface Vehiculo{}
    //Dependepcy Inversion
    // La clase esta acoplada a unos tipos de clases
    // lo que hay que hacer es declara una clase abstracta y con herencia coger lo que necesitamos, por si luego queremos cambiar el tipo de atributo y no tener que modificar todos
    private class JuguetePequenio implements Juguetes {
    }

    private class CocheGrande implements  Vehiculo{
    }
}
