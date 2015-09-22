package org.katastrofi.penultimate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.katastrofi.penultimate.Game.Phase.GENERIC;

/**
 * System command execution related to game non-dependent on the phase.
 */
public class GenericControl {

    private GenericControl() {
    }

    static Map<Game.Phase, Set<SystemAction>> get() {
        Set<SystemAction> generic = new HashSet<>();

        generic.add(new SystemAction(
                Commands.EXIT::equals,
                (c, g) -> {
                    System.exit(0);
                    return null;
                }));

        generic.add(new SystemAction(
                c -> c instanceof None,
                (c, g) -> Collections.<Result>listOf(
                        new Error(String.format("Nonesuch command %s",
                                ((None) c).input())))));

        Map<Game.Phase, Set<SystemAction>> ret = new HashMap<>();

        ret.put(GENERIC, generic);

        return ret;
    }
}
