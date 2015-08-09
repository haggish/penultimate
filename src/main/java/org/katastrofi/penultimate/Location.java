package org.katastrofi.penultimate;

/**
 * Location of a thing in a world.
 */
interface Location<T extends Location<T>> {
    T oneUnitTo(Direction direction);
}
