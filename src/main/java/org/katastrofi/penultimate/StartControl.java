package org.katastrofi.penultimate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.katastrofi.penultimate.Collections.listOf;
import static org.katastrofi.penultimate.Commands.INIT;
import static org.katastrofi.penultimate.Game.Phase.START;
import static org.katastrofi.penultimate.Info.i;

/**
 * System commands related to game start.
 */
public class StartControl {

    private StartControl() {
    }

    static Map<Game.Phase, Set<SystemAction>> get() {
        Map<Game.Phase, Set<SystemAction>> ret = new HashMap<>();

        Set<SystemAction> start = new HashSet<>();

        start.add(new SystemAction(INIT::equals,
                (c, g) -> listOf(
                        i("WELCOME! Would you like to "),
                        i("'load <characterNumber>' or"),
                        i("'build' a new character ?"),
                        i("Available characters:"),
                        i("#1: Hank")
                )));

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
