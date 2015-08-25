package org.katastrofi.penultimate;

import java.util.List;


/**
 * Commanded is an interface that entities that can be commanded implement.
 * <p/>
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
    List<Result> actOut(Command command);

}
