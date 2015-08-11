package org.katastrofi.penultimate;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNot.not;
import static org.katastrofi.penultimate.Location.coord;
import static org.katastrofi.penultimate.TestData.twoFloors;

public class TerrainTest {

    private Terrain instance;

    @Before
    public void init() {
        instance = twoFloors().terrain();
    }

    @Test
    public void
    randomCoordinatesOfTerrainTypeIsSomeOccupiedMapLocationOfThatType() {
        Location coords = instance.pickRandomCoordinatesOf(Floor.class);

        assertThat(instance.fragmentAt(coords), is(instanceOf(Floor.class)));
    }

    @Test(expected = IllegalStateException.class)
    public void noOccupiedMapLocationsByGivenTerrainTypeIsISE() {
        instance.pickRandomCoordinatesOf(Grass.class);
    }

    @Test
    public void terrainContainsLocationIfMapAtGivenLocationIsOccupied() {
        assertThat(instance.fragmentAt(coord(1, 1)), is(not(nullValue())));
        assertThat(instance.contains(coord(1, 1)), is(true));
    }
}
