package org.katastrofi.penultimate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

    private final Character hero;

    private Phase phase;

    private final Map<Phase,
            Map<Predicate<Command>,
                    BiFunction<Command, Character, List<Result>>>>
            commandMapsByPhases;

    Game(Character hero,
         Map<Phase, Map<Predicate<Command>,
                 BiFunction<Command, Character, List<Result>>>>
                 commandMapsByPhases) {
        phase = START;
        this.hero = hero;
        this.commandMapsByPhases = commandMapsByPhases;
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
        return actOutOnCommandMap(command, commandMapsByPhases.get(phase))
                .orElse(actOutOnCommandMap(
                        command, commandMapsByPhases.get(GENERIC))
                        .orElse(listOf(new Error(format("Nonesuch command %s",
                                command)))));
    }

    private Optional<List<Result>> actOutOnCommandMap(
            Command command, Map<Predicate<Command>,
            BiFunction<Command, Character, List<Result>>> commandMap) {
        return commandMap
                .entrySet().stream()
//              .peek(LOG)
                .filter(e -> e.getKey().test(command))
                .findFirst()
                .map(e -> e.getValue().apply(command, hero));
    }

    enum Phase {
        START, CHARACTER_BUILDING, MAIN_GAME, GENERIC
    }
}
