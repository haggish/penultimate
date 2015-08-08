package org.katastrofi.penultimate;

import java.util.HashMap;
import java.util.Map;

/**
 * World that is inhabited.
 */
abstract class InhabitedWorld implements World {

    private Map<String, Character> charactersByIDs = new HashMap<>();

    /**
     * Add a character to world.
     *
     * @param character added character
     */
    void add(ExistingCharacter character) {
        charactersByIDs.put(character.id(), character);
    }
}
