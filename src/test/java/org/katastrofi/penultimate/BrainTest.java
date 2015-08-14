package org.katastrofi.penultimate;

import org.junit.Test;

import java.util.Collections;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.katastrofi.penultimate.Collections.listOf;
import static org.katastrofi.penultimate.Collections.setOf;
import static org.katastrofi.penultimate.TestData.humanIn;
import static org.katastrofi.penultimate.TestData.oneFloor;

public class BrainTest {

    private Brain instance;

    private Boolean triggeredApplied = false;

    private Boolean notTriggeredApplied = false;

    private Command testedCommand;

    private Set<Event> appliedEvents;

    private Character appliedCharacter;

    private Event a = new TestData.TestEvent(), b = new TestData.TestEvent();

    @Test
    public void processingCommandAppliesActionOfEveryTriggeredSkillFromSkillSet() {
        Human human = humanIn(oneFloor());
        human.learn(new Skill(c -> true,
                new Action((c, ch) -> Collections.<Event>emptySet(),
                        (es, ch) -> triggeredApplied = true)));
        human.learn(new Skill(c -> false,
                new Action((c, ch) -> Collections.<Event>emptySet(),
                        (es, ch) -> notTriggeredApplied = true)));

        human.brain().process(new TestData.TestCommand());

        assertThat(triggeredApplied, is(true));
        assertThat(notTriggeredApplied, is(false));
    }

    @Test
    public void triggeringIsGivenProcessedCommand() {
        Human human = humanIn(oneFloor());
        TestData.TestCommand tc = new TestData.TestCommand();
        human.learn(new Skill(c -> {
            testedCommand = c;
            return true;
        }, new TestData.NOPAction()));

        human.brain().process(tc);

        assertThat(tc, is(testedCommand));
    }

    @Test
    public void appliedActionIsGivenProcessedCommandAndBrainsOwner() {
        Human human = humanIn(oneFloor());
        TestData.TestCommand tc = new TestData.TestCommand();
        human.learn(new Skill(c -> true,
                new Action((c, ch) -> setOf(a, b),
                        (es, ch) -> {
                            appliedEvents = es;
                            appliedCharacter = ch;
                        })));

        human.brain().process(tc);

        assertThat(appliedEvents, containsInAnyOrder(a, b));
        assertThat(appliedCharacter, is(human));
    }

    @Test
    public void processingReturnsAllTheResultsOfTriggeredActions() {
        World world = oneFloor();
        Human human = humanIn(world);
        human.learn(new Skill(
                c -> true,
                new Action(
                        (c, ch) -> setOf(new TestData.TestEvent(c, ch)),
                        (es, ch) -> es.toString()) // whatever
        ));
        Result a = new TestData.TestResult(),
                b = new TestData.TestResult();
        world.declare(e -> true, (e, w) -> listOf(a));
        world.declare(e -> true, (e, w) -> listOf(b));

        Set<Result> processedResults =
                human.brain().process(new TestData.TestCommand());

        assertThat(processedResults, containsInAnyOrder(a, b));
    }

    @Test
    public void learningASkillAddsItToSkillSet() {
        Human human = humanIn(oneFloor());
        Skill addedSkill = new Skill(c -> true,
                new TestData.NOPAction());

        human.learn(addedSkill);

        assertThat(human.brain().isSkilledAt(addedSkill), is(true));
    }
}
