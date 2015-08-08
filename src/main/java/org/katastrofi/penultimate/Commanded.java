package org.katastrofi.penultimate;

import java.util.Optional;

/**
 * Commanded is an interface that entities that can be commanded implement.
 *
 * Handling of a command produces an optional result.
 *
 * @see Command
 * @see Result
 */
public interface Commanded {

    /**
     * @param command command to be handled
     * @return result if applicable
     */
    Optional<Result> handle(Command command);

}
