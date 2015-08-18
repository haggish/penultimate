package org.katastrofi.penultimate;

import java.util.Set;

import static java.lang.String.format;
import static org.katastrofi.penultimate.Collections.setOf;

/**
 * Character with name.
 */
abstract class NamedCharacter extends Character {

    private final Name name;

    NamedCharacter(Name name, World world, Condition condition) {
        super(world, condition);
        this.name = name;
    }

    NamedCharacter(Name name, World world, Location location, Condition condition) {
        super(world, location, condition);
        this.name = name;
    }

    Name name() {
        return name;
    }

    @Override
    Set<Result> tick() {
        super.tick(); // TODO combine with below
        return setOf(new Info(format("%s %s", name, condition().toString())));
    }

    @Override
    public String toString() {
        return name.toString() + " " + condition().toString();
    }
}
