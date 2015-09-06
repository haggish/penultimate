package org.katastrofi.penultimate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import static java.util.Collections.unmodifiableMap;
import static java.util.stream.Collectors.toList;
import static org.katastrofi.penultimate.Game.Phase.MAIN_GAME;

/**
 * System command execution related to the main game.
 */
public class MainGameControl {

    private MainGameControl() {
    }

    static Map<Game.Phase,
            Map<Predicate<Command>,
                    BiFunction<Command, Character, List<Result>>>> get() {
        Map<Predicate<Command>, BiFunction<Command, Character, List<Result>>> main =
                new HashMap<>();

        main.put(Commands.INVENTORY::equals, (c, ch) -> ch.inventory().stream()
                .map(t -> new Info(t.genericName()))
                .collect(toList()));

        Map<Game.Phase,
                Map<Predicate<Command>,
                        BiFunction<Command, Character, List<Result>>>> ret =
                new HashMap<>();

        ret.put(MAIN_GAME, main);

        return unmodifiableMap(ret);
    }
}
