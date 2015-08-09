package org.katastrofi.penultimate;

import java.util.Set;

/**
 * Terrain defines the 'land' of the world.
 *
 * @param <C> type of location metric that is used to locate anything in terrain
 */
interface Terrain<C> {

    C pickRandomCoordinatesOf(Class<? extends TerrainFragment> tfClass);

    Boolean contains(C coordinates);

}
