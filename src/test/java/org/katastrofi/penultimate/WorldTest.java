package org.katastrofi.penultimate;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.katastrofi.penultimate.Collections.listOf;
import static org.katastrofi.penultimate.Location.coord;
import static org.katastrofi.penultimate.TestData.oneFloor;


public class WorldTest {

    private World instance;

    private TestData.TestResult a, b;

    @Before
    public void init() {
        this.instance = oneFloor();
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
                is(Optional.empty()));
    }

    @Test
    public void randomLocationOfGivenTerrainTypeIsImplementedByGivenTerrain() {
        Location location = instance.randomLocationOf(Floor.class); // "random" selection of one fragment
        assertThat(instance.terrain().fragmentAt(location), is(instanceOf(Floor.class)));
    }

    @Test
    public void
    lawsOfNatureTriggeredByEventsAreAppliedWithEventAndWorldAndResultsReturnedAsList() {
        instance.declare(e -> true,
                (e, w) -> listOf(a = new TestData.TestResult()));
        instance.declare(e -> true,
                (e, w) -> listOf(b = new TestData.TestResult()));

        assertThat(instance.experience(new TestData.TestEvent()),
                containsInAnyOrder(a, b));
    }

    @Test
    public void lawsOfNatureNotTriggeredByEventsAreIgnored() {
        instance.declare(e -> false,
                (e, w) -> listOf(a = new TestData.TestResult()));
        assertThat(instance.experience(new TestData.TestEvent()),
                is(empty()));
    }

    @Test
    public void declaringLawOfNatureAddsItToWorldsLawsOfNature() {
        assertThat(instance.experience(new TestData.TestEvent()),
                is(empty()));

        instance.declare(e -> true,
                (e, w) -> listOf(a = new TestData.TestResult()));

        instance.declare(e -> true,
                (e, w) -> listOf(a = new TestData.TestResult()));
    }
}
