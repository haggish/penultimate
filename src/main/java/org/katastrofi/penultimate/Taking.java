package org.katastrofi.penultimate;

/**
 * A discrete movement to a direction.
 */
class Taking<T extends Thing> extends EventWithOrigin<T> {

    private final Thing takenThing;

    private Taking(Thing takenThing, T thing) {
        super(thing);
        this.takenThing = takenThing;
    }

    static <T extends Thing> Taking takingOf(Thing takenThing, T thing) {
        return new Taking<>(takenThing, thing);
    }

    Thing takenThing() {
        return takenThing;
    }
}
