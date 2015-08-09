package org.katastrofi.penultimate;

import static java.lang.String.format;
import static java.util.UUID.randomUUID;

/**
 * A thing that exists somewhere in a world and can be identified uniquely.
 *
 * @param <T> location metric that is used to locate the thing
 */
abstract class ExistingIdentifiableThing<T extends Location> {

    private final String id;

    private final InhabitedWorld<T> world;

    private final T location;

    ExistingIdentifiableThing(InhabitedWorld<T> world) {
        this.world = world;
        this.location = world.locateRandomly(this);
        this.id = randomUUID().toString();
        world.add(this);
        System.out.println(format("Thing %s born!", this));
    }

    String id() {
        return id;
    }

    InhabitedWorld world() {
        return world;
    }

    T location() {
        return location;
    }

}
