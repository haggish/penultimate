package org.katastrofi.penultimate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import static java.util.Collections.unmodifiableMap;
import static java.util.stream.Collectors.toSet;
import static org.katastrofi.penultimate.Game.Phase.MAIN_GAME;

/**
 * System command execution related to the main game.
 */
public class MainGameControl {

    private MainGameControl() {
    }

    static Map<Game.Phase,
            Map<Predicate<Command>, BiFunction<Command, Character, Set<Result>>>> get() {
        Map<Predicate<Command>, BiFunction<Command, Character, Set<Result>>> main =
                new HashMap<>();

        main.put(Commands.EXIT::equals, (c, ch) -> {
            System.exit(0);
            return null;
        });

        main.put(Commands.INVENTORY::equals, (c, ch) -> ch.inventory().stream()
                .map(t -> new Info(t.genericName()))
                .collect(toSet()));

        main.put(c -> c instanceof None,
                (c, ch) -> Collections.<Result>setOf(
                        new Error(String.format("Nonesuch command %s",
                                ((None) c).input()))));

        Map<Game.Phase,
                Map<Predicate<Command>,
                        BiFunction<Command, Character, Set<Result>>>> ret =
                new HashMap<>();

        ret.put(MAIN_GAME, main);

        return unmodifiableMap(ret);
    }
}
