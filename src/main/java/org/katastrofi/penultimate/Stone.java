package org.katastrofi.penultimate;

/**
 * Just a stone.
 */
public class Stone<T extends Location<T>>
        extends ExistingIdentifiableThing<T> {

    Stone(InhabitedWorld<T> world) {
        super(world);
    }

    @Override
    public String toString() {
        return "Stone";
    }
}
