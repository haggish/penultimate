package org.katastrofi.penultimate;

import org.junit.Before;
import org.junit.Test;

import static java.util.Collections.emptySet;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsNot.not;
import static org.katastrofi.penultimate.Collections.listOf;
import static org.katastrofi.penultimate.Collections.setOf;

public class CharacterTest {

    private Character instance;

    private World world;

    private Boolean processedByBrain = false;

    private TestData.TestResult a, b;

    @Before
    public void init() {
        world = TestData.oneFloor();
        instance = TestData.humanIn(world);
        a = new TestData.TestResult();
        b = new TestData.TestResult();
    }

    @Test
    public void existingActingCharacterHasInitiallyEmptyActionHistory() {
        assertThat(instance.history().get(), is(empty()));
    }

    @Test
    public void actingOutCommandDelegatesItForBrainToProcess() {
        instance.brain().learn(new Skill(c -> true,
                new Action((c, ch) -> emptySet(),
                        (c, ch) -> processedByBrain = true)));

        instance.actOut(new TestData.TestCommand());

        assertThat(processedByBrain, is(true));
    }

    @Test
    public void actingOutCommandReturnsResultsProcessedByBrain() {
        instance.brain().learn(new Skill(c -> true,
                new Action((c, ch) -> setOf(new TestData.TestEvent(c, ch)),
                        (c, ch) -> new TestData.NOPAction())));
        world.declare(e -> true, (e, w) -> listOf(a, b));

        assertThat(instance.actOut(new TestData.TestCommand()),
                containsInAnyOrder(a, b));
    }

    @Test
    public void learningSkillMakesBrainLearnTheSkill() {
        Skill newSkill = new Skill(e -> true, new TestData.NOPAction());

        instance.learn(newSkill);

        assertThat(instance.isSkilledAt(newSkill), is(true));
    }

    @Test
    public void takingThingAddsItToPossessions() {
        assertThat(instance.inventory(), is(empty()));
        Stone stone = new Stone(world);

        instance.take(stone);

        assertThat(instance.inventory(), contains(stone));
    }

    @Test
    public void initiallyEventHistoryIsEmpty() {
        assertThat(instance.history().get(), is(empty()));
    }

    @Test
    public void pushingEventToHistoryAddsIt() {
        Event e = new TestData.TestEvent(new TestData.TestCommand(), instance);

        instance.history().push(e);

        assertThat(instance.history().get(), contains(e));
    }

    @Test
    public void addingActionToHistoryTenActionsLongRemovesTheOldest() {
        Event first =
                new TestData.TestEvent(new TestData.TestCommand(), instance);
        Event e = new TestData.TestEvent(new TestData.TestCommand(), instance);

        instance.history().push(first);
        for (int idx = 0; idx < 9; idx++) {
            instance.history().push(e);
        }
        assertThat(instance.history().get(), hasItem(first));

        instance.history().push(e);

        assertThat(instance.history().get(), not(hasItem(first)));
    }
}
