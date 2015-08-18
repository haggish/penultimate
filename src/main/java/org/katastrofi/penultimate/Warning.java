package org.katastrofi.penultimate;

/**
 * A warning result.
 */
public class Warning implements Result {

    private final String message;

    public Warning(String message) {
        this.message = message;
    }
}
