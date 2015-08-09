package org.katastrofi.penultimate;

/**
 * Character with name.
 */
abstract class NamedCharacter<T extends Location<T>>
        extends ExistingActingCharacter<T> {

    private final Name name;

    NamedCharacter(Name name, InhabitedWorld<T> world) {
        super(world);
        this.name = name;
    }

    Name name() {
        return name;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
