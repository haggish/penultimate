package org.katastrofi.penultimate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.katastrofi.penultimate.Direction.EAST;
import static org.katastrofi.penultimate.Direction.NORTH;
import static org.katastrofi.penultimate.Direction.NORTHEAST;
import static org.katastrofi.penultimate.Direction.NORTHWEST;
import static org.katastrofi.penultimate.Direction.SOUTH;
import static org.katastrofi.penultimate.Direction.SOUTHEAST;
import static org.katastrofi.penultimate.Direction.SOUTHWEST;
import static org.katastrofi.penultimate.Direction.WEST;
import static org.katastrofi.penultimate.Location.coord;

import org.junit.Test;


public class LocationTest {

    private Location instance = coord(5, 5);

    @Test
    public void locationOneUnitEastIsOneXMore() {
        assertThat(instance.oneUnitTo(EAST),
                is(coord(instance.x() + 1, instance.y())));
    }

    @Test
    public void locationOneUnitWestIsOneXLess() {
        assertThat(instance.oneUnitTo(WEST),
                is(coord(instance.x() - 1, instance.y())));
    }

    @Test
    public void locationOneUnitNorthIsOneYMore() {
        assertThat(instance.oneUnitTo(NORTH),
                is(coord(instance.x(), instance.y() + 1)));
    }

    @Test
    public void locationOneUnitSouthIsOneYLess() {
        assertThat(instance.oneUnitTo(SOUTH),
                is(coord(instance.x(), instance.y() - 1)));
    }

    @Test
    public void locationOneUnitNortheastIsOneXOneYMore() {
        assertThat(instance.oneUnitTo(NORTHEAST),
                is(coord(instance.x() + 1, instance.y() + 1)));
    }

    @Test
    public void locationOneUnitSoutheastIsOneXMoreOneYLess() {
        assertThat(instance.oneUnitTo(SOUTHEAST),
                is(coord(instance.x() + 1, instance.y() - 1)));
    }

    @Test
    public void locationOneUnitSouthwestIsOneXOneYLess() {
        assertThat(instance.oneUnitTo(SOUTHWEST),
                is(coord(instance.x() - 1, instance.y() - 1)));
    }

    @Test
    public void locationOneUnitNorthwestIsOneXLessOneYMore() {
        assertThat(instance.oneUnitTo(NORTHWEST),
                is(coord(instance.x() - 1, instance.y() + 1)));
    }

    @Test
    public void locationOneUnitOtherIsThatLocation() {
        assertThat(instance.oneUnitTo(null), is(instance));
    }

}
