package org.katastrofi.penultimate;

import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.katastrofi.penultimate.TestData.humanIn;
import static org.katastrofi.penultimate.TestData.oneFloor;

public class BrainTest {

    private Brain instance;

    private Boolean triggeredApplied = false;

    private Boolean notTriggeredApplied = false;

    private Command testedCommand;

    @Test
    public void processingCommandAppliesActionOfEveryTriggeredSkillFromSkillSet() {
        Human human = humanIn(oneFloor());
        human.learn(new Skill(c -> true,
                new Action((c, ch) -> Collections.<Event>emptySet(),
                        (c, ch) -> triggeredApplied = true)));
        human.learn(new Skill(c -> false,
                new Action((c, ch) -> Collections.<Event>emptySet(),
                        (c, ch) -> notTriggeredApplied = true)));

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

    }

    @Test
    public void processingReturnsAllTheResultsOfTriggeredActions() {

    }

    @Test
    public void learningASkillAddsItToSkillSet() {

    }
}
