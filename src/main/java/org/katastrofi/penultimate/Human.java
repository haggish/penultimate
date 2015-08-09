package org.katastrofi.penultimate;

import static org.katastrofi.penultimate.InstanceOf.instanceOf;
import static org.katastrofi.penultimate.Movement.movementTo;
import static org.katastrofi.penultimate.Sets.setOf;

/**
 * Human character.
 */
class Human<T extends Location<T>> extends NamedCharacter<T> {

    Human(Name name, InhabitedWorld<T> world) {
        super(name, world);
        learn(new Skill<T>(instanceOf(Move.class),
                new Action<T>(
                        (cmd, character) ->
                                setOf(movementTo(((Move) cmd).direction(),
                                        this)),
                        (cmd, character) ->
                                character.moveOneUnitTo(
                                        ((Move) cmd).direction())
                )));
    }
}
