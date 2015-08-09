package org.katastrofi.penultimate;

import static org.katastrofi.penultimate.InstanceOf.instanceOf;
import static org.katastrofi.penultimate.Movement.movementTo;
import static org.katastrofi.penultimate.CollectionUtils.setOf;

/**
 * Various skills
 */
class Skills {

    private Skills() {
    }

    static <T extends Location<T>> Skill<T> moving() {
        return new Skill<T>(instanceOf(Move.class),
                new Action<T>(
                        (cmd, character) ->
                                setOf(movementTo(((Move) cmd).direction(),
                                        character)),
                        (cmd, character) ->
                                character.moveOneUnitTo(
                                        ((Move) cmd).direction())
                ));
    }
}
