package org.katastrofi.penultimate;

import java.util.Set;

/**
 * Action executed by a character.
 */
abstract class Action<T extends Location> {

    Set<Result> execute(Command command, ExistingActingCharacter<T> character) {
        return null;
    }

    abstract Set<Result> meat(Command command,
                              ExistingActingCharacter<T> character);
}
