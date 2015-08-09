package org.katastrofi.penultimate;

import java.util.Set;
import java.util.function.Predicate;

import static java.util.Collections.emptySet;

/**
 * Skill that character's brain can do.
 */
public class Skill<T extends Location> {

    private final Predicate<Command> trigger;

    private final Action<T> action;


    Skill(Predicate<Command> trigger, Action<T> action) {
        this.trigger = trigger;
        this.action = action;
    }

    Set<Result> apply(Command command, ExistingActingCharacter<T> character) {
        if (trigger.test(command)) {
            return action.execute(command, character);
        } else {
            return emptySet();
        }
    }

    Predicate<Command> trigger() {
        return trigger;
    }

    Action<T> action() {
        return action;
    }
}
