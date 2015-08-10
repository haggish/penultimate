package org.katastrofi.penultimate;

import org.junit.Test;

import java.util.*;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.katastrofi.penultimate.TestData.humanIn;
import static org.katastrofi.penultimate.TestData.oneFloor;

public class BrainTest {

    private Brain instance;

    private Boolean triggeredApplied = false;

    private Boolean notTriggeredNotApplied = false;

    @Test
    public void processingCommandAppliesActionOfEveryTriggeredSkillFromSkillSet() {
        World world = oneFloor();
        Human human = humanIn(world);
        human.learn(new Skill(c -> true,
                new Action((c, ch) -> Collections.<Event>emptySet(),
                        (c, ch) -> triggeredApplied = true)));
        human.learn(new Skill(c -> false,
                new Action((c, ch) -> Collections.<Event>emptySet(),
                        (c, ch) -> notTriggeredNotApplied = true)));

        human.brain().process(new TestData.TestCommand());

        assertThat(triggeredApplied, is(true));
        assertThat(notTriggeredNotApplied, is(true));
    }

    @Test
    public void triggeringIsGivenProcessedCommand() {

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
