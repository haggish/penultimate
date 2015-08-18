package org.katastrofi.penultimate;

import java.util.Set;

import static java.util.UUID.randomUUID;
import static org.katastrofi.penultimate.Collections.setOf;


/**
 * A thing that exists somewhere in a world and can be identified uniquely.
 */
abstract class Thing {

    private final String id;

    private final World world;

    private Location location;

    Thing(World world) {
        this(world, world.randomLocationOf(Floor.class));
    }

    Thing(World world, Location location) {
        this.world = world;
        this.location = location;
        this.id = randomUUID().toString();
        world.add(this);
    }

    String id() {
        return id;
    }

    World world() {
        return world;
    }

    Location location() {
        return location;
    }

    void moveOneUnitTo(Direction direction) {
        location = location.oneUnitTo(direction);
        System.out.println("Now at " + location);
    }

    /**
     * Whatever happens when one unit of time passes.
     */
    Set<Result> tick() {
        // nothing by default
        return setOf();
    }

    void locateTo(Location location) {
        this.location = location;
    }

    public String genericName() {
        return this.getClass().getSimpleName();
    }
}
