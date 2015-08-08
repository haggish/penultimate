package org.katastrofi.penultimate;

import java.util.Optional;

/**
 * Human character.
 */
class Human extends NamedCharacter {

    Human(Name name, InhabitedWorld world) {
        super(name, world);
    }

    @Override
    public Optional<Result> handle(Command command) {
        return null;
    }
}
