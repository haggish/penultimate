package org.katastrofi.penultimate;

abstract class BaseCommand implements Command {

    private final String input;

    BaseCommand(String input) {
        this.input = input;
    }

    String input() {
        return input;
    }
}
