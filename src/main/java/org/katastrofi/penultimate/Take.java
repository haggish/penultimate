package org.katastrofi.penultimate;

/**
 * Taking of an object.
 */
public class Take implements Command {

    private final Thing thing;

    private Take(Thing thing) {
        this.thing = thing;
    }

    Thing thing() {
        return thing;
    }
}
