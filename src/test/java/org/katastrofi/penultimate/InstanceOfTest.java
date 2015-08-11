package org.katastrofi.penultimate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.katastrofi.penultimate.InstanceOf.instanceOf;

import org.junit.Test;


public class InstanceOfTest {

    @Test
    public void commandPassesTestIfItIsOfGivenClass() {
        assertThat(instanceOf(TestData.TestCommand.class)
                .test(new TestData.TestCommand()), is(true));
    }

    @Test
    public void commandDoesntPassTestIfItIsntOfGivenClass() {
        assertThat(instanceOf(None.class)
                .test(new TestData.TestCommand()), is(false));
    }
}
