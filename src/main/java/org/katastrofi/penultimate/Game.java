package org.katastrofi.penultimate;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.logging.Logger;

import static java.lang.String.format;
import static org.katastrofi.penultimate.Collections.listOf;
import static org.katastrofi.penultimate.Commands.INIT;
import static org.katastrofi.penultimate.Game.Phase.GENERIC;
import static org.katastrofi.penultimate.Game.Phase.MAIN_GAME;
import static org.katastrofi.penultimate.Game.Phase.START;


/**
 * Game is the main application class that handles the system commands.
 *
 * @see Command
 * @see SystemCommand
 */
class Game implements Commanded {

    private static final Logger LOGGER = Logger.getLogger("Game");

    private static final Consumer<Map.Entry<Predicate<Command>,
            BiFunction<Command, Character, List<Result>>>> LOG =
            e -> LOGGER.info(e.getKey() + "->" + e.getValue());

    private Character hero;

    private Phase phase;

    private Persistence persistence;

    private final Map<Phase, Set<SystemAction>> actionsByPhases;

    Game(Character hero, Map<Phase, Set<SystemAction>> actionsByPhases) {
        phase = START;
        this.hero = hero;
        this.actionsByPhases = actionsByPhases;
        actOut(INIT).forEach(System.out::println);
    }

    Character hero() {
        return hero;
    }

    Phase phase() {
        return phase;
    }

    void play() {
        phase = MAIN_GAME;
    }

    @Override
    public List<Result> actOut(Command command) {
        return actOutOnCommandMap(command, actionsByPhases.get(phase))
                .orElse(actOutOnCommandMap(
                        command, actionsByPhases.get(GENERIC))
                        .orElse(listOf(new Error(format("Nonesuch command %s",
                                command)))));
    }

    private Optional<List<Result>> actOutOnCommandMap(
            Command command, Set<SystemAction> actions) {
        return actions.stream()
//              .peek(LOG)
                .filter(a -> a.test(command))
                .findFirst()
                .map(a -> a.apply(command, this));
    }

    enum Phase {
        START, CHARACTER_BUILDING, MAIN_GAME, GENERIC
    }
}
