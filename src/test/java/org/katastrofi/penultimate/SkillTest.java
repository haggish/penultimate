package org.katastrofi.penultimate;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.core.Is.is;
import static org.katastrofi.penultimate.Collections.listOf;
import static org.katastrofi.penultimate.Collections.setOf;
import static org.katastrofi.penultimate.TestData.humanIn;
import static org.katastrofi.penultimate.TestData.oneFloor;

public class SkillTest {

    private Skill instance;

    private Command appliedCommand;

    private Character appliedCharacter;

    private Character givenCharacter;

    private Event expectedEvent;

    private Result expectedResult;

    @Before
    public void init() {
        givenCharacter = humanIn(oneFloor());
        instance = new Skill(
                c -> c instanceof None,
                new Action(
                        (c, ch) -> setOf(expectedEvent =
                                new TestData.TestEvent(c, ch)),
                        (c, ch) -> {
                            appliedCommand = c;
                            appliedCharacter = ch;
                        }));
        givenCharacter.world().declare(
                e -> e.equals(expectedEvent),
                (e, w) -> listOf(expectedResult = new TestData.TestResult()));
    }

    @Test
    public void
    applyingSkillToCommandAndCharacterReturnsEmptyResultIfCommandDoesntTriggerSkill() {
        assertThat(instance.apply(Commands.EXIT, givenCharacter), is(empty()));
    }

    @Test
    public void
    applyingSkillToCommandAndCharacterReturnsResultsOfActionAppliedToGivenCommandAndCharacterIfCommandTriggersTheSkill() {
        assertThat(instance.apply(new None<>("such"), givenCharacter),
                contains(expectedResult));
    }
}
