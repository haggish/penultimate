package org.katastrofi.penultimate;

/**
 * Two-dimensional, block-based terrain (think Ultimate III).
 */
class TwoDimensionalBlockBasedTerrain implements Terrain {

    private final SparseMatrix<TerrainFragment> map;

    TwoDimensionalBlockBasedTerrain(SparseMatrix<TerrainFragment> map) {
        this.map = map;
    }
}
