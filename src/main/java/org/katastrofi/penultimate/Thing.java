package org.katastrofi.penultimate;

/**
 * A thing in a world.
 */
interface Thing {

    static final Thing NOTHING = () -> "nothing";

    String genericName();

}
