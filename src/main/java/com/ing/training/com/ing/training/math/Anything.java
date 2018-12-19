package com.ing.training.com.ing.training.math;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

public class Anything {

    private String s = "";

    /**
     * Constructor without parameter
     */
    public Anything() {

    }

    /**
     * Constuctor with parameter
     *
     * @param s bla bla bla
     */
    public Anything(String s) {
        this.s = s;
    }

    /**
     * Factory method
     *
     * @return
     * @throws ParseException
     */
    public static Anything getInstance() throws ParseException {
        NumberFormat formatter = new DecimalFormat("#.## €");
        formatter.parse("123,45€");
        return new Anything();
    }

    public String getS() {
        return s;
    }
}
