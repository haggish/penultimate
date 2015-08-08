package org.katastrofi.penultimate;

/**
 * None is a fallback class for inputs that aren't matched by the parser.
 */
class None<T> implements SystemCommand {

    private final T input;

    None(T input) {
        this.input = input;
    }

    T input() {
        return input;
    }
}
