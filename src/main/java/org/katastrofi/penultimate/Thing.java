package org.katastrofi.penultimate;

/**
 * A thing in a world.
 */
interface Thing {

    Thing NOTHING = () -> "nothing";

    String genericName();

}
