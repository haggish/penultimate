package org.katastrofi.penultimate;

import static org.katastrofi.penultimate.Skills.moving;
import static org.katastrofi.penultimate.Skills.taking;

/**
 * Human character.
 */
class Human<T extends Location<T>> extends NamedCharacter<T> {

    Human(Name name, InhabitedWorld<T> world) {
        super(name, world);
        learn(moving());
        learn(taking());
    }
}
