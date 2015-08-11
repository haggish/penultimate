package org.katastrofi.penultimate;

/**
 * Just a stone.
 */
public class Stone extends ExistingIdentifiableThing {

    Stone(World world) {
        super(world);
    }

    Stone(World world, Location location) {
        super(world, location);
    }

    @Override
    public String toString() {
        return "Stone";
    }
}
