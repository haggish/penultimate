package org.katastrofi.penultimate;

/**
 * A discrete movement to a direction.
 */
class Movement<T extends Thing> extends EventWithOrigin<T> {

    private final Direction direction;

    private Movement(Direction direction, T thing) {
        super(thing);
        this.direction = direction;
    }

    static <T extends Thing> Movement movementTo(Direction direction, T thing) {
        return new Movement<>(direction, thing);
    }

    Direction direction() {
        return direction;
    }
}
