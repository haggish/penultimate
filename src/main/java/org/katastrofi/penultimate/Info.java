package org.katastrofi.penultimate;

/**
 * Generic informative result.
 */
class Info implements Result {

    private final String message;

    Info(String message) {
        this.message = message;
    }

    String message() {
        return message;
    }

}
