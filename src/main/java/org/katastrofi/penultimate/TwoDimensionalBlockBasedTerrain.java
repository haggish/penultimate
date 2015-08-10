package org.katastrofi.penultimate;

import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

/**
 * Two-dimensional, block-based terrain (think Ultimate III).
 */
class TwoDimensionalBlockBasedTerrain implements Terrain {

    private final SparseMatrix<TerrainFragment> map;

    private final Random random = new Random();

    TwoDimensionalBlockBasedTerrain(SparseMatrix<TerrainFragment> map) {
        this.map = map;
    }

    public Location pickRandomCoordinatesOf(
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

    @Override
    public Boolean contains(Location coordinates) {
        return map.get(coordinates) != null;
    }
}
