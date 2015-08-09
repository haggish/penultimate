package org.katastrofi.penultimate;

import java.util.function.Predicate;

class InstanceOf<T> implements Predicate<Command> {

    private final Class<T> clazz;

    private InstanceOf(Class<T> clazz) {
        this.clazz = clazz;
    }

    static <T> InstanceOf<T> instanceOf(Class<T> clazz) {
        return new InstanceOf<T>(clazz);
    }

    @Override
    public boolean test(Command command) {
        return command != null && command.getClass().equals(clazz);
    }
}
