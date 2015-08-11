package org.katastrofi.penultimate;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Random;


/**
 * Two-dimensional, block-based terrain (think Ultimate III).
 */
class Terrain {

    private final SparseMatrix<TerrainFragment> map;

    private final Random random = new Random();

    Terrain(SparseMatrix<TerrainFragment> map) {
        this.map = map;
    }

    Location pickRandomCoordinatesOf(
            Class<? extends TerrainFragment> tfClass) {
        List<Location> locationsOfTerrainType = map.coordinates().stream()
                .filter(c -> map.get(c).getClass().equals(tfClass))
                .collect(toList());
        if (locationsOfTerrainType.isEmpty()) {
            throw new IllegalStateException("No terrain of that class");
        }
        int randomIdx = random.nextInt() % locationsOfTerrainType.size();

        return locationsOfTerrainType.get(randomIdx);
    }

    Boolean contains(Location coordinates) {
        return map.get(coordinates) != null;
    }

    TerrainFragment fragmentAt(Location coordinates) {
        return map.get(coordinates);
    }
}
