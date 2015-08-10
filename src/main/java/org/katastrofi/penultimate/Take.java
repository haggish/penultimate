package org.katastrofi.penultimate;

/**
 * Taking of an object.
 */
public class Take implements Command {

    private final String thingName;

    Take(String thingName) {
        this.thingName = thingName;
    }

    String thingName() {
        return thingName;
    }
}
