package org.katastrofi.penultimate;

/**
 * Load a character.
 */
public class Load implements Command {

    private final String id;

    Load(String id) {
        this.id = id;
    }
}
