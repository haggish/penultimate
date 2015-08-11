package org.katastrofi.penultimate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

import org.junit.Before;
import org.junit.Test;


public class GameTest {

    private Game instance;

    @Before
    public void init() {
        instance = new Game();
    }

    @Test
    public void actingOutNoneCommandGivesResultOfOneError() {
        assertThat(instance.actOut(new None<>("gibberish")),
                contains(instanceOf(Error.class)));
    }

    @Test
    public void actingOutUnknownCommandGivesResultOfOneError() {
        assertThat(instance.actOut(new TestData.TestCommand()),
                contains(instanceOf(Error.class)));
    }

}
