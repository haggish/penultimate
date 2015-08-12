package org.katastrofi.penultimate;

/**
 * A .
 */
class Dropping<T extends Character,
        DT extends Thing> extends EventWithOrigin<T> {

    private final DT droppedThing;

    private Dropping(DT droppedThing, T thing) {
        super(thing);
        this.droppedThing = droppedThing;
    }

    static <T extends Character,
            DT extends Thing> Dropping dropOf(
            DT droppedThing, T thing) {
        return new Dropping<>(droppedThing, thing);
    }

    DT droppedThing() {
        return droppedThing;
    }
}
