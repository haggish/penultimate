package org.katastrofi.penultimate;

/**
 * None is a fallback class for inputs that aren't matched by the parser.
 */
class None<T> extends Commands.DescribedSystemCommand {

    private final T input;

    None(T input) {
        super(input.toString());
        this.input = input;
    }

    T input() {
        return input;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        None<?> none = (None<?>) o;

        return !(input != null ? !input.equals(none.input) : none.input != null);

    }

    @Override
    public int hashCode() {
        return input != null ? input.hashCode() : 0;
    }
}
