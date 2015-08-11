package org.katastrofi.penultimate;

import static java.util.UUID.randomUUID;


/**
 * A thing that exists somewhere in a world and can be identified uniquely.
 */
abstract class ExistingIdentifiableThing implements Thing {

    private final String id;

    private final World world;

    private Location location;

    ExistingIdentifiableThing(World world) {
        this(world, world.randomLocationOf(Floor.class));
    }

    ExistingIdentifiableThing(World world, Location location) {
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

    public String genericName() {
        return this.getClass().getSimpleName();
    }

}
