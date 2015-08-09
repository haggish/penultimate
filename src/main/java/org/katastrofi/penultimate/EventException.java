package org.katastrofi.penultimate;

/**
 * Exception resulting from an event in a world.
 */
class EventException extends RuntimeException {

    private final Event event;

    EventException(Event event) {
        this.event = event;
    }
}
