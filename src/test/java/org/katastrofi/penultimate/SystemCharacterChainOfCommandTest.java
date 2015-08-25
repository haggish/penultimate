package org.katastrofi.penultimate;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SystemCharacterChainOfCommandTest {

    private Game game;

    private SystemCharacterChainOfCommand instance;

    private Commanded handler;

    private World world = new WhiteCube();

    private Character hero;

    @Before
    public void init() {
        hero = new Human(new Name("Roderick", "D.", "Jaynes"),
                world) {
            @Override
            public List<Result> actOut(Command command) {
                handler = this;
                return emptyList();
            }
        };
        game = new Game(hero, new HashMap<>()) {
            @Override
            public List<Result> actOut(Command command) {
                handler = this;
                return emptyList();
            }
        };
        instance = new SystemCharacterChainOfCommand(game);
    }

    @Test
    public void systemCommandsAreActedOutByGivenGame() {
        instance.actOut(new SystemCommand() {
        });
        assertThat(handler, is(game));
    }

    @Test
    public void nonSystemCommandsAreActedOutByGamesHero() {
        instance.actOut(new TestData.TestCommand());
        assertThat(handler, is(hero));
    }
}
