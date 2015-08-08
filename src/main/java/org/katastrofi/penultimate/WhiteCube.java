package org.katastrofi.penultimate;

/**
 * White Cube is a very boring world indeed.
 */
class WhiteCube extends FlatConstrainedWorld {

    WhiteCube() {
        this(new TwoDimensionalBlockBasedTerrain(null /* map */));
    }

    WhiteCube(TwoDimensionalBlockBasedTerrain terrain) {
        super(terrain);
    }

    @Override
    public void experience(Event event) {
        // TODO
    }

}
