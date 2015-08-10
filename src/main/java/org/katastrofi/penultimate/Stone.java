package org.katastrofi.penultimate;

/**
 * Just a stone.
 */
public class Stone extends ExistingIdentifiableThing {

    Stone(World world) {
        super(world);
    }

    @Override
    public String toString() {
        return "Stone";
    }
}
