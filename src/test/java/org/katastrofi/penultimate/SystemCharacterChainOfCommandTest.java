package org.katastrofi.penultimate;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static java.util.Collections.emptySet;
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
            public Set<Result> actOut(Command command) {
                handler = this;
                return emptySet();
            }
        };
        game = new Game(hero) {
            @Override
            public Set<Result> actOut(Command command) {
                handler = this;
                return emptySet();
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
