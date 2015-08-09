package org.katastrofi.penultimate;

/**
 * An event from some distinct origin.
 */
abstract class EventWithOrigin<T extends Thing> implements Event {

    private T origin;

    EventWithOrigin(T origin) {
        this.origin = origin;
    }

    T origin() {
        return origin;
    }
}
