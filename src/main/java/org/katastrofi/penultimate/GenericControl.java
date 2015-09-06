package org.katastrofi.penultimate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import static org.katastrofi.penultimate.Game.Phase.GENERIC;

/**
 * System command execution related to game non-dependent on the phase.
 */
public class GenericControl {

    private GenericControl() {
    }

    static Map<Game.Phase, Map<Predicate<Command>,
            BiFunction<Command, Character, List<Result>>>> get() {
        Map<Predicate<Command>,
                BiFunction<Command, Character, List<Result>>> generic =
                new HashMap<>();

        generic.put(Commands.EXIT::equals, (c, ch) -> {
            System.exit(0);
            return null;
        });

        generic.put(c -> c instanceof None,
                (c, ch) -> Collections.<Result>listOf(
                        new Error(String.format("Nonesuch command %s",
                                ((None) c).input()))));

        Map<Game.Phase, Map<Predicate<Command>,
                BiFunction<Command, Character, List<Result>>>> ret =
                new HashMap<>();

        ret.put(GENERIC, generic);

        return ret;
    }
}
