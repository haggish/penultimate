package org.katastrofi.penultimate;

import static java.util.UUID.randomUUID;


/**
 * A thing that exists somewhere in a world and can be identified uniquely.
 */
abstract class ExistingIdentifiableThing implements Thing {

    private final String id;

    private final InhabitedWorld world;

    private Location location;

    ExistingIdentifiableThing(InhabitedWorld world) {
        this.world = world;
        this.location = world.randomLocationOf(Floor.class);
        this.id = randomUUID().toString();
        world.add(this);
    }

    String id() {
        return id;
    }

    InhabitedWorld world() {
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
