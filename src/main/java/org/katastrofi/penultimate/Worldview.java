package org.katastrofi.penultimate;

/**
 * A character's view of the world.
 * <p/>
 * Typically character is not aware of the whole of the world and covers
 * more of it by exploring.
 */
class Worldview {

    private World world;

    Worldview(World world) {
        this.world = world;
    }

}
