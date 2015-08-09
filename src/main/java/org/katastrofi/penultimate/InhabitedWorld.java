package org.katastrofi.penultimate;

import java.util.HashMap;
import java.util.Map;

/**
 * World that is inhabited.
 */
abstract class InhabitedWorld<T extends Location<T>> implements World {

    private Map<String, ExistingIdentifiableThing<T>> thingsByIDs =
            new HashMap<>();

    /**
     * Add a thing to world.
     *
     * @param thing added thing
     */
    void add(ExistingIdentifiableThing<T> thing) {
        thingsByIDs.put(thing.id(), thing);
    }

    abstract T locateRandomly(ExistingIdentifiableThing<T> character);
}
