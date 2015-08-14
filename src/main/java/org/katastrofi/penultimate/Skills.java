package org.katastrofi.penultimate;

import static org.katastrofi.penultimate.Collections.setOf;
import static org.katastrofi.penultimate.Dropping.dropOf;
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
                    (events, character) -> events.stream()
                            .filter(e -> e instanceof Movement)
                            .forEach(e -> {
                                Movement movement = (Movement) e;
                                movement.origin().moveOneUnitTo(
                                        movement.direction());
                            })));

    final static Skill TAKING = new Skill(instanceOf(Take.class),
            new Action(
                    (cmd, character) -> character.world().thingByNameAndPlace(
                            ((Take) cmd).thingName(), character.location())
                            .map(t -> Collections.<Event>setOf(
                                    takingOf(t, character)))
                            .orElse(java.util.Collections.<Event>emptySet()),
                    (events, character) -> events.stream()
                            .filter(e -> e instanceof Taking)
                            .forEach(e ->
                                    character.take(((Taking) e).takenThing()))
            ));

    final static Skill DROPPING = new Skill(instanceOf(Drop.class),
            new Action(
                    (cmd, character) -> character.inventory().stream()
                            .filter(t -> t.genericName().equals(
                                    ((Drop) cmd).thingName()))
                            .findFirst().map(t -> Collections.<Event>setOf(
                                    dropOf(t, character)))
                            .orElse(java.util.Collections.<Event>emptySet()),
                    (events, character) -> events.stream()
                            .filter(e -> e instanceof Dropping)
                            .forEach(e ->
                                    character.drop(((Dropping) e)
                                            .droppedThing()))
            ));
}
