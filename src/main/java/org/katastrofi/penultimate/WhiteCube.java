package org.katastrofi.penultimate;

import static org.katastrofi.penultimate.TwoDimensionalCoordinates.coord;

/**
 * White Cube is a very boring world indeed.
 */
class WhiteCube extends FlatConstrainedWorld {

    WhiteCube() {
        this(createMap());
    }

    WhiteCube(TwoDimensionalBlockBasedTerrain terrain) {
        super(terrain);
    }

    @Override
    public void experience(Event event) {
        if (event instanceof Movement) {
            Movement movement = (Movement) event;
            if (movement.origin() instanceof Character) {
                Character character = (Character) movement.origin();
                // TODO uhh
            }
        }
    }

    private static TwoDimensionalBlockBasedTerrain createMap() {
        SparseMatrix<TerrainFragment> map = new SparseMatrix<>();

        for (int idx1 = 0; idx1 < 50; idx1++) {
            for (int idx2 = 0; idx2 < 50; idx2++) {
                map.set(coord(idx1, idx2), new Floor());
            }
        }

        return new TwoDimensionalBlockBasedTerrain(map);
    }

    public String toString() {
        return "WHITE CUBE";
    }
}
