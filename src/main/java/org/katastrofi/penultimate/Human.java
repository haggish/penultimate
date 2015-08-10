package org.katastrofi.penultimate;

import static org.katastrofi.penultimate.Skills.MOVING;
import static org.katastrofi.penultimate.Skills.TAKING;


/**
 * Human character.
 */
class Human extends NamedCharacter {

    Human(Name name, InhabitedWorld world) {
        super(name, world);
        learn(MOVING);
        learn(TAKING);
    }
}
