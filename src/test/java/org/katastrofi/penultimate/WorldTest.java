package org.katastrofi.penultimate;

import static java.util.Optional.empty;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.katastrofi.penultimate.Location.coord;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;


public class WorldTest {

    private World instance;

    @Before
    public void init() {
        this.instance = TestData.oneFloor();
    }

    @Test
    public void thingsAtAddedThingsLocationReturnAddedThings() {
        Stone stone = new Stone(instance);

        assertThat(instance.thingsAt(coord(1, 1)), contains(stone));
    }

    @Test
    public void
    thingByNameAndPlaceIsTheThingInGivenPlaceByGivenName() {
        Stone stone = new Stone(instance);

        assertThat(instance.thingByNameAndPlace(stone.genericName(), coord(1, 1)),
                is(Optional.of(stone)));
    }

    @Test
    public void thingByNameAndPlaceIsEmptyIfNoSuchThingInGivenPlace() {
        assertThat(instance.thingByNameAndPlace("Stone", coord(1, 1)),
                is(empty()));
    }

    @Test
    public void randomLocationOfGivenTerrainTypeIsImplementedByGivenTerrain() {
        Location location = instance.randomLocationOf(Floor.class); // "random" selection of one fragment
        assertThat(instance.terrain().fragmentAt(location), is(instanceOf(Floor.class)));
    }

}
