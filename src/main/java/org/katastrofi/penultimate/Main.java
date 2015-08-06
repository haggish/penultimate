package org.katastrofi.penultimate;

public class Main {

    public static void main(String args[]) {
        new CLI(System.console(), new DefaultParser()).run();
    }
}
