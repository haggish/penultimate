package org.katastrofi.penultimate;

/**
 * Generic informative result.
 */
class Info implements Result {

    private final String message;

    static Info i(String msg) {
        return new Info(msg);
    }

    Info(String message) {
        this.message = message;
    }

    String message() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
