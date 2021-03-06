package org.katastrofi.penultimate;

import static org.katastrofi.penultimate.LawsOfNature.DROPPING;
import static org.katastrofi.penultimate.LawsOfNature.MOVING;
import static org.katastrofi.penultimate.LawsOfNature.TAKING;
import static org.katastrofi.penultimate.Location.coord;


/**
 * White Cube is a very boring world indeed.
 */
class WhiteCube extends World {

    WhiteCube() {
        this(createMap());
    }

    WhiteCube(Terrain terrain) {
        super(terrain);
        declare(e -> e instanceof Movement, MOVING);
        declare(e -> e instanceof Taking, TAKING);
        declare(e -> e instanceof Dropping, DROPPING);
        declare(Event.TICK::equals, LawsOfNature.TIME);
    }

    private static Terrain createMap() {
        SparseMatrix<TerrainFragment> map = new SparseMatrix<>();

        for (int idx1 = 0; idx1 < 50; idx1++) {
            for (int idx2 = 0; idx2 < 50; idx2++) {
                map.set(coord(idx1, idx2), new Floor());
            }
        }

        return new Terrain(map);
    }

    public String toString() {
        return "WHITE CUBE";
    }
}
