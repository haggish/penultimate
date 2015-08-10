package org.katastrofi.penultimate;

import static java.util.Collections.emptyList;
import static org.katastrofi.penultimate.Collections.listOf;
import static org.katastrofi.penultimate.Location.coord;

import java.util.List;


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
    public List<Result> experience(Event event) {
        if (event instanceof Movement) {
            Movement movement = (Movement) event;
            if (movement.origin() instanceof Character) {
                @SuppressWarnings("unchecked")
                ExistingActingCharacter character =
                        (ExistingActingCharacter) movement.origin();
                Location destination =
                        character.location().oneUnitTo(movement.direction());
                if (terrain().contains(destination)) {
                    List<Result> res = listOf(
                            new Info("Moving to " + movement.direction()));
                    thingsAt(destination).stream()
                            .forEach(t -> res.add(
                                    new Info("There is a " + t + " here")));
                    return res;
                } else {
                    return listOf(new Error("Can't move outside the map"));
                }
            }
        }
        // TODO implement taking of thing off the world (to character possessions)
        return emptyList();
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
