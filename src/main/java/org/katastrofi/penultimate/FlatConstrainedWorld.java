package org.katastrofi.penultimate;

/**
 * An inhabited world that is flat and constrained (think of a big room).
 * <p/>
 * This would not be for example Earth as it is a surface of a sphere that
 * does not have bounds.
 */
abstract class FlatConstrainedWorld extends InhabitedWorld {

    private final TwoDimensionalBlockBasedTerrain terrain;

    FlatConstrainedWorld(TwoDimensionalBlockBasedTerrain terrain) {
        this.terrain = terrain;
    }

}
