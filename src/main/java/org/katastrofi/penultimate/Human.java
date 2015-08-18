package org.katastrofi.penultimate;

import static org.katastrofi.penultimate.Skills.DROPPING;
import static org.katastrofi.penultimate.Skills.MOVING;
import static org.katastrofi.penultimate.Skills.TAKING;


/**
 * Human character.
 */
class Human extends NamedCharacter {

    Human(Name name, World world, Location location) {
        super(name, world, location, new HumanCondition(200));
        learn(MOVING);
        learn(TAKING);
        learn(DROPPING);
    }

    Human(Name name, World world) { // todo clean up constructor mess
        super(name, world, new HumanCondition(200));
        learn(MOVING);
        learn(TAKING);
        learn(DROPPING);
    }
}
