package org.katastrofi.penultimate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.katastrofi.penultimate.Location.coord;
import static org.katastrofi.penultimate.TestData.humanIn;
import static org.katastrofi.penultimate.TestData.oneFloor;
import static org.katastrofi.penultimate.TestData.twoFloors;

import org.junit.Before;
import org.junit.Test;

public class ExistingIdentifiableThingTest {

    private ExistingIdentifiableThing instance;

    private World world;

    @Before
    public void init() {
        world = oneFloor();
        instance = humanIn(world);
    }

    @Test
    public void existingIdentifiableThingIsAddedToTheWorldGiven() {
        assertThat(world.thingsAt(coord(1, 1)), contains(instance));
    }

    @Test
    public void
    existingIdentifiableThingIsLocatedRandomlyByItsGivenWorldToSomeFloorTerrainFragment() {
        assertThat(instance.location(), is(coord(1, 1)));
        assertThat(world.terrain().fragmentAt(coord(1, 1)),
                is(instanceOf(Floor.class)));
    }

    @Test
    public void
    movingOneUnitToGivenDirectionUpdatesThingsLocationToLocationOneUnitToGivenDirection() {
        world = twoFloors();
        instance = humanIn(world, coord(1, 1));
        assertThat(instance.location(), is(coord(1, 1)));

        instance.moveOneUnitTo(Direction.NORTH);

        assertThat(instance.location(), is(coord(1, 2)));
    }

    @Test
    public void thingsGenericNameIsItsSimpleClassName() {
        assertThat(instance.genericName(), is(instance.getClass().getSimpleName()));
    }
}
