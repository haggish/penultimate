package org.katastrofi.penultimate;

import static java.util.stream.Collectors.toSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * World that is inhabited.
 */
abstract class InhabitedWorld implements World {

    private Map<String, ExistingIdentifiableThing> thingsByIDs =
            new HashMap<>();

    /**
     * Add a thing to world.
     *
     * @param thing added thing
     */
    void add(ExistingIdentifiableThing thing) {
        thingsByIDs.put(thing.id(), thing);
    }

    abstract Location locateRandomly(ExistingIdentifiableThing character);

    Set<ExistingIdentifiableThing> thingsAt(Location location) {
        return thingsByIDs.values().stream()
                .filter(eit -> eit.location().equals(location))
                .collect(toSet());
    }

}
