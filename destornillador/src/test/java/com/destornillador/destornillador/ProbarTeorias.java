package com.destornillador.destornillador;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assume.assumeNotNull;
import static org.junit.Assume.assumeThat;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class ProbarTeorias {
    /*
     * @DataPoints public static String[] names() { return new
     * String[]{"first","second","abc","123",null}; }
     */
    @DataPoint
    public static Puntas punta = new Puntas("punta", 1.0, "e");

    @DataPoint
    public static Puntas punta2 = new Puntas("punta2", 1.0, "e");

    /*
     * Generated Email ID returned by EmailIdUtility.createEmailID must contain
     * first part and second part passed to it
     */
    @Theory
    public void testPuntas(Puntas d1, Puntas d2) throws Exception {
        System.out.println(String.format("Testing with %s and %s", d1, d2));
        assumeNotNull(punta, punta2);
        /*
         * Same assumptions as assumeNotNull(). Added only to demonstrate usage
         * of assertThat
         */
        assumeThat(d1, notNullValue());
        assumeThat(d2, notNullValue());
        assumeThat(d2.getNombre(), is("punta"));

    }
}