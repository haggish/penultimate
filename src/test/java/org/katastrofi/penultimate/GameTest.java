package org.katastrofi.penultimate;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.katastrofi.penultimate.TestData.humanIn;
import static org.katastrofi.penultimate.TestData.oneFloor;


public class GameTest {

    private Game instance;

    @Before
    public void init() {
        Map<Game.Phase, Set<SystemAction>> commands =
                new HashMap<>();
        commands.put(Game.Phase.GENERIC, new HashSet<>());
        commands.put(Game.Phase.START, new HashSet<>());
        instance = new Game(humanIn(oneFloor()), commands);
    }

    @Test
    public void actingOutUnknownCommandGivesResultOfOneError() {
        assertThat(instance.actOut(new TestData.TestCommand()),
                contains(instanceOf(Error.class)));
    }

}
