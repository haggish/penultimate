package org.katastrofi.penultimate;

/**
 * Terrain defines the 'land' of the world.
 *
 * @param <C> type of location metric that is used to locate anything in terrain
 */
interface Terrain<C> {

    C pickRandomCoordinatesOf(Class<? extends TerrainFragment> tfClass);

}
