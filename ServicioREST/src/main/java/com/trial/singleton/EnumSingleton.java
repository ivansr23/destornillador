package com.trial.singleton;

import org.hibernate.validator.internal.util.stereotypes.ThreadSafe;
import org.springframework.util.Assert;

import static org.springframework.util.Assert.isTrue;

enum Color {

    RED(1), GREEN(2), YELLOW(3);

    private int nCode;

    private Color(int _nCode) {

        this.nCode = _nCode;

    }

    @Override

    public String toString() {

        return String.valueOf(this.nCode);

    }

}


public class EnumSingleton {
    public static void main(String[] args) {
        Color red = Color.RED;
        Color red2 = Color.RED;

        isTrue(red == red2);// return true

    }
}