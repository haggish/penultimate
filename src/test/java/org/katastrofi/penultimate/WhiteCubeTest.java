package org.katastrofi.penultimate;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.katastrofi.penultimate.Direction.NORTH;
import static org.katastrofi.penultimate.Location.coord;
import static org.katastrofi.penultimate.Movement.movementTo;
import static org.katastrofi.penultimate.TestData.oneFloor;

public class WhiteCubeTest {

    private WhiteCube instance;

    @Before
    public void init() {
        instance = new WhiteCube();
    }

    @Test
    public void terrainIs50By50CubeOfFloorTerrainType() {
        assertThat(instance.terrain().contains(coord(0, 0)), is(true));
        assertThat(instance.terrain().contains(coord(49, 49)), is(true));
        assertThat(instance.terrain().contains(coord(50, 49)), is(false));
        assertThat(instance.terrain().contains(coord(49, 50)), is(false));
        assertThat(instance.terrain().fragmentAt(coord(0, 0)),
                is(instanceOf(Floor.class)));
        assertThat(instance.terrain().fragmentAt(coord(49, 49)),
                is(instanceOf(Floor.class)));
    }

    @Test
    public void youCanMove() {
        assertThat(instance.experience(movementTo(NORTH,
                TestData.humanIn(oneFloor(), coord(49, 49)))),
                contains(instanceOf(Error.class)));
    }
}
