package org.katastrofi.penultimate;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.katastrofi.penultimate.Commands.EXIT;
import static org.katastrofi.penultimate.Direction.EAST;
import static org.katastrofi.penultimate.Direction.NORTH;
import static org.katastrofi.penultimate.Direction.NORTHEAST;
import static org.katastrofi.penultimate.Direction.NORTHWEST;
import static org.katastrofi.penultimate.Direction.SOUTH;
import static org.katastrofi.penultimate.Direction.SOUTHEAST;
import static org.katastrofi.penultimate.Direction.SOUTHWEST;
import static org.katastrofi.penultimate.Direction.WEST;

public class CommandMappingsTest {

    private CommandMappings instance;

    @Before
    public void init() {
        instance = new CommandMappings();
    }

    @Test
    public void verbExitIsMappedToExit() {
        assertThat(instance.get().get("exit").apply("input"),
                is(EXIT));
    }

    @Test
    public void verbNIsMappedToMovingNorth() {
        assertThat(instance.get().get("n").apply("input"),
                is(Move.to(NORTH)));
    }

    @Test
    public void verbSIsMappedToMovingSouth() {
        assertThat(instance.get().get("s").apply("input"),
                is(Move.to(SOUTH)));
    }

    @Test
    public void verbEIsMappedToMovingEast() {
        assertThat(instance.get().get("e").apply("input"),
                is(Move.to(EAST)));
    }

    @Test
    public void verbWIsMappedToMovingWest() {
        assertThat(instance.get().get("w").apply("input"),
                is(Move.to(WEST)));
    }

    @Test
    public void verbNEIsMappedToMovingNortheast() {
        assertThat(instance.get().get("ne").apply("input"),
                is(Move.to(NORTHEAST)));
    }

    @Test
    public void verbSEIsMappedToMovingSoutheast() {
        assertThat(instance.get().get("se").apply("input"),
                is(Move.to(SOUTHEAST)));
    }

    @Test
    public void verbSWIsMappedToMovingSouthwest() {
        assertThat(instance.get().get("sw").apply("input"),
                is(Move.to(SOUTHWEST)));
    }

    @Test
    public void verbNWIsMappedToMovingNorthwest() {
        assertThat(instance.get().get("nw").apply("input"),
                is(Move.to(NORTHWEST)));
    }

    @Test
    public void verbTakeIsMappedToTaking() {
        assertThat(instance.get().get("take").apply("take monkey"),
                is(instanceOf(Take.class)));
    }
}
