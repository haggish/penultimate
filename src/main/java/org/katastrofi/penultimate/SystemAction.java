package org.katastrofi.penultimate;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * System action triggered by a system command.
 */
public class SystemAction
        implements Predicate<Command>, BiFunction<Command, Game, List<Result>> {

    private final Predicate<Command> trigger;

    private final BiFunction<Command, Game, List<Result>> action;

    SystemAction(Predicate<Command> trigger,
                 BiFunction<Command, Game, List<Result>> action) {
        this.trigger = trigger;
        this.action = action;
    }

    @Override
    public boolean test(Command command) {
        return trigger.test(command);
    }

    @Override
    public List<Result> apply(Command command, Game game) {
        return action.apply(command, game);
    }

}
