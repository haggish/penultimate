package org.katastrofi.penultimate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Collections.emptyList;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.core.Is.is;
import static org.katastrofi.penultimate.Collections.listOf;
import static org.katastrofi.penultimate.Collections.setOf;
import static org.katastrofi.penultimate.TestData.humanIn;
import static org.katastrofi.penultimate.TestData.oneFloor;

@RunWith(MockitoJUnitRunner.class)
public class ActionTest {

    private Action instance;

    private World world;

    private Set<Event> experiencedEvents = new HashSet<>();

    private Human human;

    private TestData.TestEvent a, b;

    private Command commandForMeat;

    private Character characterForMeat;

    private List<Result> returnedResult = emptyList();

    @Before
    public void init() {
        World world = oneFloor();
        world.declare(e -> e instanceof TestData.TestEvent,
                (e, w) -> {
                    experiencedEvents.add(e);
                    return returnedResult;
                });
        human = humanIn(world);
        instance = new Action(
                (c, ch) -> setOf(
                        a = new TestData.TestEvent(c, ch), b = new TestData.TestEvent(c, ch)),
                (c, ch) -> {
                    commandForMeat = c;
                    characterForMeat = ch;
                });
    }

    @Test
    public void givenEventProducersEventsAreExperiencedByWorldOfCharacter() {
        instance.apply(new TestData.TestCommand(), human);

        assertThat(experiencedEvents, containsInAnyOrder(a, b));
    }

    @Test
    public void eventProducerIsGivenAppliedCommandAndCharacter() {
        TestData.TestCommand tc = new TestData.TestCommand();

        instance.apply(tc, human);

        assertThat(a.c, is(tc));
        assertThat(a.ch, is(human));
        assertThat(b.c, is(tc));
        assertThat(b.ch, is(human));
    }

    @Test
    public void
    resultsFromWorldsEventExperiencesArePushedIntoCharactersActionHistory() {
        instance.apply(new TestData.TestCommand(), human);

        assertThat(human.history().get(), containsInAnyOrder(a, b));
    }

    @Test
    public void
    ifResultsFromWorldsEventExperiencesAreOkMeatIsExecutedUsingAppliedCommandAndCharacter() {
        TestData.TestCommand tc = new TestData.TestCommand();

        instance.apply(tc, human);

        assertThat(commandForMeat, is(tc));
        assertThat(characterForMeat, is(human));
    }

    @Test
    public void ifResultsContainErrorsMeatIsNotExecuted() {
        returnedResult = listOf(new Error("horror"));

        instance.apply(new TestData.TestCommand(), human);

        assertThat(commandForMeat, is(nullValue()));
        assertThat(characterForMeat, is(nullValue()));
    }

    @Test
    public void resultsFromWorldsEventExperiencesAreReturned() {
        Info info = new Info("haa");
        returnedResult = listOf(info);

        assertThat(instance.apply(new TestData.TestCommand(), human), contains(info));
    }

}
