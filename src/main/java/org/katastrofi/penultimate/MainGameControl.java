package org.katastrofi.penultimate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.unmodifiableMap;
import static java.util.stream.Collectors.toList;
import static org.katastrofi.penultimate.Game.Phase.MAIN_GAME;

/**
 * System command execution related to the main game.
 */
public class MainGameControl {

    private MainGameControl() {
    }

    static Map<Game.Phase, Set<SystemAction>> get() {
        Set<SystemAction> main = new HashSet<>();

        main.add(new SystemAction(
                Commands.INVENTORY::equals,
                (c, g) -> g.hero().inventory().stream()
                        .map(t -> new Info(t.genericName()))
                        .collect(toList())));

        Map<Game.Phase, Set<SystemAction>> ret = new HashMap<>();

        ret.put(MAIN_GAME, main);

        return unmodifiableMap(ret);
    }
}
