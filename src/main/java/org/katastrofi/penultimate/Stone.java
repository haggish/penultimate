package org.katastrofi.penultimate;

/**
 * Just a stone.
 */
public class Stone extends ExistingIdentifiableThing {

    Stone(InhabitedWorld world) {
        super(world);
    }

    @Override
    public String toString() {
        return "Stone";
    }
}
