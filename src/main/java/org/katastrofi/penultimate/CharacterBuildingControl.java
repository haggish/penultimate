package org.katastrofi.penultimate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.katastrofi.penultimate.Game.Phase.CHARACTER_BUILDING;

/**
 * System command execution related to character building.
 */
public class CharacterBuildingControl {

    private CharacterBuildingControl() {
    }

    static Map<Game.Phase, Set<SystemAction>> get() {
        Map<Game.Phase, Set<SystemAction>> ret = new HashMap<>();

        Set<SystemAction> cb = new HashSet<>();

        ret.put(CHARACTER_BUILDING, cb);

        return ret;
    }
}
