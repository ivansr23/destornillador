package com.destornillador.destornillador;

import lombok.AllArgsConstructor;
import java.util.concurrent.Callable;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PruebaHilo  implements Callable<Integer>  {

    private Integer id;

    /*@Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Soy hilo" + id);
            Thread.sleep(10000);
            System.out.println("Soy otra vez hilo" + id);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }*/

    @Override
    public Integer call() throws Exception {
        int total = 0;
        for(int i=0;i<5;i++) {
          total+=i;
          System.out.println("holaaaaaaaaaaa hilo");
          Thread.sleep(300);
        }
        System.out.println("d"+Thread.currentThread().getName());
        return total;
    }
}
