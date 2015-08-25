package org.katastrofi.penultimate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import static org.katastrofi.penultimate.Game.Phase.CHARACTER_BUILDING;

/**
 * System command exe ution related to character building.
 */
public class CharacterBuildingControl {

    private CharacterBuildingControl() {
    }

    static Map<Game.Phase, Map<Predicate<Command>,
            BiFunction<Command, Character, List<Result>>>> get() {
        Map<Game.Phase, Map<Predicate<Command>,
                BiFunction<Command, Character, List<Result>>>> ret =
                new HashMap<>();

        Map<Predicate<Command>,
                BiFunction<Command, Character, List<Result>>> cb =
                new HashMap<>();

        ret.put(CHARACTER_BUILDING, cb);

        return ret;
    }
}
