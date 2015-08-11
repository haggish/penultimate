package org.katastrofi.penultimate;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.core.Is.is;
import static org.katastrofi.penultimate.Location.coord;

public class SparseMatrixTest {

    private SparseMatrix<String> instance;

    private String existingElement = "thing";

    @Before
    public void init() {
        instance = new SparseMatrix<>();
        instance.set(coord(2, 2), existingElement);
    }

    @Test
    public void gettingNonExistentElementInLocationIsNull() {
        assertThat(instance.get(coord(1, 1)), is(nullValue()));
    }

    @Test
    public void gettingExistingElementInLocationIsThatElement() {
        assertThat(instance.get(coord(2, 2)), is(existingElement));
    }

    @Test
    public void settingElementToLocationSetsElementToThatLocation() {
        instance.set(coord(1, 1), existingElement);
        assertThat(instance.get(coord(1, 1)), is(existingElement));
    }

    @Test
    public void coordinatesOfMatrixAreAllOccupiedLocationsOfMatrix() {
        assertThat(instance.coordinates(), contains(coord(2, 2)));
    }

}
