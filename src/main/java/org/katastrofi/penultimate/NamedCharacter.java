package org.katastrofi.penultimate;

/**
 * Character with name.
 */
abstract class NamedCharacter extends ExistingCharacter {

    private final Name name;

    NamedCharacter(Name name, InhabitedWorld world) {
        super(world);
        this.name = name;
    }

    Name name() {
        return name;
    }
}
