package org.katastrofi.penultimate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.katastrofi.penultimate.Skills.MOVING;
import static org.katastrofi.penultimate.Skills.TAKING;
import static org.katastrofi.penultimate.TestData.humanIn;
import static org.katastrofi.penultimate.TestData.oneFloor;

import org.junit.Before;
import org.junit.Test;


public class HumanTest {

    private Human instance;

    @Before
    public void init() {
        instance = humanIn(oneFloor());
    }

    @Test
    public void humanKnowsHowToMove() {
        assertThat(instance.isSkilledAt(MOVING), is(true));
    }

    @Test
    public void humanKnowsHowToTake() {
        assertThat(instance.isSkilledAt(TAKING), is(true));
    }
}
