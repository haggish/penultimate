package org.katastrofi.penultimate;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.katastrofi.penultimate.Direction.NORTH;
import static org.katastrofi.penultimate.LawsOfNature.MOVING;
import static org.katastrofi.penultimate.Location.coord;
import static org.katastrofi.penultimate.Movement.movementTo;
import static org.katastrofi.penultimate.TestData.humanIn;
import static org.katastrofi.penultimate.TestData.twoFloors;

public class LawsOfNatureTest {

    @Test
    public void
    experiencingMovementResultsInInfoThatCharacterIsMovingIfTerrainHasDestination() {
        World world = twoFloors();
        assertThat(MOVING.apply(
                        movementTo(NORTH, humanIn(world, coord(1, 1))), world),
                contains(instanceOf(Info.class)));
    }

    @Test
    public void
    experiencingMovementResultsInErrorIfTerrainDoesntHaveDestination() {
        World world = twoFloors();
        assertThat(MOVING.apply(
                        movementTo(NORTH, humanIn(world, coord(1, 2))), world),
                contains(instanceOf(Error.class)));
    }

    @Test
    public void
    experiencingMovementResultsInInfoThatThereIsAThingIfThereAreThingsAtDestination() {
        World world = twoFloors();
        new Stone(world, coord(1, 2));
        assertThat(MOVING.apply(
                        movementTo(NORTH, humanIn(world, coord(1, 1))), world),
                contains(instanceOf(Info.class), instanceOf(Info.class)));
    }

}
