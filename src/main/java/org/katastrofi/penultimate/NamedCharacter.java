package org.katastrofi.penultimate;

/**
 * Character with name.
 */
abstract class NamedCharacter extends ExistingActingCharacter {

    private final Name name;

    NamedCharacter(Name name, World world) {
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
