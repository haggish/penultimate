package org.katastrofi.penultimate;

import static org.katastrofi.penultimate.Collections.setOf;
import static org.katastrofi.penultimate.InstanceOf.instanceOf;
import static org.katastrofi.penultimate.Movement.movementTo;
import static org.katastrofi.penultimate.Taking.takingOf;


/**
 * Various skills
 */
class Skills {

    private Skills() {
    }

    final static Skill MOVING = new Skill(instanceOf(Move.class),
            new Action(
                    (cmd, character) ->
                            setOf(movementTo(((Move) cmd).direction(),
                                    character)),
                    (cmd, character) ->
                            character.moveOneUnitTo(
                                    ((Move) cmd).direction())
            ));

    final static Skill TAKING = new Skill(instanceOf(Take.class),
            new Action(
                    (cmd, character) -> character.world().thingByNameAndPlace(
                            ((Take) cmd).thingName(), character.location())
                            .map(t -> Collections.<Event>setOf(
                                    takingOf(t, character)))
                            .orElse(Collections.<Event>setOf(
                                    takingOf(Thing.NOTHING, character))),
                    (Command cmd, ExistingActingCharacter character) -> {
                        character.world().thingByNameAndPlace(
                                ((Take) cmd).thingName(), character.location())
                                .ifPresent(character::take);
                    }
            ));

}
