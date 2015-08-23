package org.katastrofi.penultimate;

import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import static org.katastrofi.penultimate.Collections.setOf;
import static org.katastrofi.penultimate.Game.Phase.MAIN_GAME;


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
                    BiFunction<Command, Character, Set<Result>>>>
            commandMapsByPhases;

    Game(Character hero,
         Map<Phase, Map<Predicate<Command>,
                 BiFunction<Command, Character, Set<Result>>>>
                 commandMapsByPhases) {
        this.phase = MAIN_GAME;
        this.hero = hero;
        this.commandMapsByPhases = commandMapsByPhases;
    }

    Character hero() {
        return hero;
    }

    @Override
    public Set<Result> actOut(Command command) {
        return commandMapsByPhases.get(phase).entrySet().stream()
                .filter(e -> e.getKey().test(command))
                .findFirst()
                .map(e -> e.getValue().apply(command, hero))
                .orElse(setOf(new Error(String.format("Nonesuch command %s",
                        command))));
    }

    enum Phase {
        CHARACTER_BUILDING, MAIN_GAME
    }
}
