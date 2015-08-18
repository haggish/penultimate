package org.katastrofi.penultimate;

import java.util.Set;

/**
 * Condition of a character.
 */
interface Condition {

    /**
     * Applies changes of one game turn to character.
     *
     * @return visible results of aging
     */
    Set<Result> age();

}
