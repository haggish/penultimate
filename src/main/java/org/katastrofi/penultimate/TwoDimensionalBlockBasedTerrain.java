package org.katastrofi.penultimate;

/**
 * Two-dimensional, block-based terrain (think Ultimate III).
 */
class TwoDimensionalBlockBasedTerrain
        implements Terrain<TwoDimensionalCoordinates> {

    private final SparseMatrix<TerrainFragment> map;

    TwoDimensionalBlockBasedTerrain(SparseMatrix<TerrainFragment> map) {
        this.map = map;
    }

    public TwoDimensionalCoordinates pickRandomCoordinatesOf(
            Class<? extends TerrainFragment> tfClass) {
        return map.coordinates().stream()
                .filter(c -> map.get(c).getClass().equals(tfClass))
                .findAny()
                .orElseThrow(() ->
                        new IllegalStateException("No terrain of that class"));
    }
}
