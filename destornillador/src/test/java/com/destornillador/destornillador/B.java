package com.destornillador.destornillador;

import org.junit.Test;
import org.junit.experimental.categories.Category;


@Category({Probar.class})
public class B {
  
  @Category({Probar.class})
  @Test
  public void c() {
      System.out.println("soy C");
  }
  
  @Category({Probar2.class})
  @Test(timeout=9000)
  public void D()  {
      Hiloo hilo = new Hiloo(1);
      hilo.run();
      System.out.println("soy D");
  }
}

