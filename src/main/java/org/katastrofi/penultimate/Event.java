package org.katastrofi.penultimate;

/**
 * Event is something that happens for example from carrying out a command.
 * <p/>
 * For example, commanding the player's character to go west produces a Move
 * event westwards. World experiences events and possibly changes from them,
 * or produces more events.
 *
 * @see Command
 * @see World
 */
interface Event {
    Event TICK = new Event() {
    };
}
