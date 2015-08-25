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
 * System commands related to game start.
 */
public class StartControl {

    private StartControl() {
    }

    static Map<Game.Phase, Map<Predicate<Command>,
            BiFunction<Command, Character, List<Result>>>> get() {
        Map<Game.Phase, Map<Predicate<Command>,
                BiFunction<Command, Character, List<Result>>>> ret =
                new HashMap<>();

        Map<Predicate<Command>,
                BiFunction<Command, Character, List<Result>>> start =
                new HashMap<>();

        start.put(INIT::equals,
                (c, ch) -> listOf(
                        new Info("WELCOME! Would you like to "),
                        new Info("'load <characterNumber>' or"),
                        new Info("'build' a new character ?")
                ));

        // result = kuka hero on ladattu jos kukaan

        // load / build paivittaa heron
        // play etenee peliin, hero pitaa olla

        // TODO INIT / hero == null -> info("load or new")
        // lists saved chars, "load 3" is load 3rd listed char

        // TODO LOAD # -> hero != null ->

        // TODO hero != null -> info("play or load # or new"):
        // play -> main, new -> rebuild, load # -> load another


        ret.put(START, start);

        return ret;
    }

}
