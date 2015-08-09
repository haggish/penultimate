package org.katastrofi.penultimate;

import static org.katastrofi.penultimate.Skills.moving;

/**
 * Human character.
 */
class Human<T extends Location<T>> extends NamedCharacter<T> {

    Human(Name name, InhabitedWorld<T> world) {
        super(name, world);
        learn(moving());
    }
}
