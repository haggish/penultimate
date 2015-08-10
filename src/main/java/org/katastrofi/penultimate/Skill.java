package org.katastrofi.penultimate;

import static java.util.Collections.emptySet;

import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Predicate;


/**
 * Skill that character's brain can do.
 */
public class Skill implements
        BiFunction<Command, ExistingActingCharacter, Set<Result>> {

    private final Predicate<Command> trigger;

    private final Action action;

    Skill(Predicate<Command> trigger, Action action) {
        this.trigger = trigger;
        this.action = action;
    }

    public Set<Result> apply(Command command,
            ExistingActingCharacter character) {
        if (trigger.test(command)) {
            return action.apply(command, character);
        } else {
            return emptySet();
        }
    }

    Predicate<Command> trigger() {
        return trigger;
    }

    Action action() {
        return action;
    }
}
