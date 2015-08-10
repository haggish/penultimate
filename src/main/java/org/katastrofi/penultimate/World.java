package org.katastrofi.penultimate;

import java.util.List;


/**
 * World is all state that the game environment contains, including terrain
 * and characters.
 * <p>
 * It experiences events emitted by characters (and others, including itself?)
 * which can trigger changes in world, including more events.
 *
 * @see Event
 */
interface World {

    /**
     * Experience an event.
     *
     * @param event event to be experienced
     */
    List<Result> experience(Event event);

}
