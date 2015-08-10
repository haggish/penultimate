package org.katastrofi.penultimate;

/**
 * Terrain defines the 'land' of the world.
 */
interface Terrain {

    Location pickRandomCoordinatesOf(Class<? extends TerrainFragment> tfClass);

    Boolean contains(Location coordinates);

}
