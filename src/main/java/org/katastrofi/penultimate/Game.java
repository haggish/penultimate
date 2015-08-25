package org.katastrofi.penultimate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import static org.katastrofi.penultimate.Collections.listOf;
import static org.katastrofi.penultimate.Commands.INIT;
import static org.katastrofi.penultimate.Game.Phase.START;


/**
 * Game is the main application class that handles the system commands.
 *
 * @see Command
 * @see SystemCommand
 */
class Game implements Commanded {

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
        this.phase = START;
        this.hero = hero;
        this.commandMapsByPhases = commandMapsByPhases;
        actOut(INIT);
    }

    Character hero() {
        return hero;
    }

    @Override
    public List<Result> actOut(Command command) {
        return commandMapsByPhases.getOrDefault(phase, new HashMap<>())
                .entrySet().stream()
                .filter(e -> e.getKey().test(command))
                .findFirst()
                .map(e -> e.getValue().apply(command, hero))
                .orElse(listOf(new Error(String.format("Nonesuch command %s",
                        command))));
    }

    enum Phase {
        START, CHARACTER_BUILDING, MAIN_GAME
    }
}
