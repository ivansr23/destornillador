package com.destornillador.destornillador;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PruebaHilo extends Thread {

    private Integer id;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Soy hilo" + id);
            Thread.sleep(1000);
            System.out.println("Soy otra vez hilo" + id);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
