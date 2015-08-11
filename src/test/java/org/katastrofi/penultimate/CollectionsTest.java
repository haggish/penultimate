package org.katastrofi.penultimate;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.katastrofi.penultimate.Collections.listOf;
import static org.katastrofi.penultimate.Collections.setOf;

public class CollectionsTest {

    @Test
    public void setOfGivenElementsReturnsSetWithThoseElements() {
        assertThat(setOf("a", "b"), containsInAnyOrder("a", "b"));
    }

    @Test
    public void listOfGivenElementsReturnsListWithThoseElements() {
        assertThat(listOf("a", "b"), containsInAnyOrder("a", "b"));
    }
}
