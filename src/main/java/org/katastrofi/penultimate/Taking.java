package org.katastrofi.penultimate;

/**
 * A .
 */
class Taking<T extends Character,
        TT extends Thing> extends EventWithOrigin<T> {

    private final TT takenThing;

    private Taking(TT takenThing, T thing) {
        super(thing);
        this.takenThing = takenThing;
    }

    static <T extends Character,
            TT extends Thing> Taking takingOf(
            TT takenThing, T thing) {
        return new Taking<>(takenThing, thing);
    }

    TT takenThing() {
        return takenThing;
    }
}
