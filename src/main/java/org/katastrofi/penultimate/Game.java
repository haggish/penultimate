package org.katastrofi.penultimate;

import java.util.Set;

import static org.katastrofi.penultimate.CollectionUtils.setOf;

/**
 * Game is the main application class that handles the system commands.
 *
 * @see Command
 * @see SystemCommand
 */
class Game implements Commanded {

    private final InhabitedWorld<XYCoordinates> world;

    private final ExistingActingCharacter<XYCoordinates> hero;

    Game() {
        world = new WhiteCube();
        hero = new Human<>(new Name("Billy", "Bob", "Norris"), world);
        new Stone<>(world);
    }

    Character hero() {
        return hero;
    }

    @Override
    public Set<Result> actOut(Command command) {
        if (command instanceof Exit) {
            System.exit(0);
        } else if (command instanceof None) {
            return setOf(new Error(String.format("Nonesuch command %s",
                    ((None) command).input())));
        }
        return setOf(new Error("Nonesuch command"));
    }
}
