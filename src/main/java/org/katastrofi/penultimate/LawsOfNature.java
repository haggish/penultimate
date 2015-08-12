package org.katastrofi.penultimate;

import java.util.List;
import java.util.function.BiFunction;

import static org.katastrofi.penultimate.Collections.listOf;

/**
 * Laws of nature.
 */
class LawsOfNature {

    private LawsOfNature() {
    }

    static final BiFunction<Event, World, List<Result>> MOVING =
            (e, w) -> {
                Movement movement = (Movement) e;
                @SuppressWarnings("unchecked")
                Character character =
                        (Character) movement.origin();
                Location destination =
                        character.location().oneUnitTo(movement.direction());
                if (w.terrain().contains(destination)) {
                    List<Result> res = listOf(
                            new Info("Moving to " + movement.direction()));
                    w.thingsAt(destination).stream()
                            .forEach(t -> res.add(
                                    new Info("There is a " + t + " here")));
                    return res;
                } else {
                    return listOf(new Error("Can't move outside the map"));
                }
            };

    static final BiFunction<Event, World, List<Result>> TAKING =
            (e, w) -> {
                Thing thing = ((Taking) e).takenThing();
                w.remove(thing);
                return listOf(new Info("You take the " + thing));
            };

    static final BiFunction<Event, World, List<Result>> DROPPING =
            (e, w) -> {
                Dropping dropping = (Dropping) e;
                Thing thing = dropping.droppedThing();
                thing.locateTo(dropping.origin().location());
                w.add(thing);
                return listOf(new Info("You dropped the " + thing));
            };
}
