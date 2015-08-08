package org.katastrofi.penultimate;

import static java.util.UUID.randomUUID;

/**
 * Identifiable character.
 */
abstract class ExistingCharacter implements Character {

    private final String id;

    private final InhabitedWorld world;

    ExistingCharacter(InhabitedWorld world) {
        this.world = world;
        this.id = randomUUID().toString();
        world.add(this);
    }

    String id() {
        return id;
    }

    InhabitedWorld world() {
        return world;
    }

}
