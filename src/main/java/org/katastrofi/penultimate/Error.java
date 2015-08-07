package org.katastrofi.penultimate;

public class Error implements Result {

    private final String errorMessage;

    Error(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    String errorMessage() {
        return errorMessage;
    }

    public String toString() {
        return errorMessage;
    }
}
