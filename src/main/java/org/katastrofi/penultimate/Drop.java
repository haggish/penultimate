package org.katastrofi.penultimate;

/**
 * Dropping of an object.
 */
public class Drop implements Command {

    private final String thingName;

    Drop(String thingName) {
        this.thingName = thingName;
    }

    String thingName() {
        return thingName;
    }
}
