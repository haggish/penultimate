package org.katastrofi.penultimate;

class None implements SystemCommand {

    private final String input;

    None(String input) {
        this.input = input;
    }

    String input() {
        return input;
    }
}
