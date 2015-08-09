package org.katastrofi.penultimate;

import java.util.Set;

import static java.util.Collections.emptySet;
import static org.katastrofi.penultimate.Sets.setOf;
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
    public Set<Result> experience(Event event) {
        if (event instanceof Movement) {
            Movement movement = (Movement) event;
            if (movement.origin() instanceof Character) {
                @SuppressWarnings("unchecked")
                ExistingActingCharacter<TwoDimensionalCoordinates> character =
                        (ExistingActingCharacter<TwoDimensionalCoordinates>)
                                movement.origin();
                if (terrain().contains(
                        character.location().oneUnitTo(movement.direction()))) {
                    return setOf(new Info("Moving to " + movement.direction()));
                } else {
                    return setOf(new Error("Can't move outside the map"));
                }
            }
        }
        return emptySet();
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
