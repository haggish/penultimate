package org.katastrofi.penultimate;

import java.util.Optional;

/**
 * Game is the main application class that handles the system commands.
 *
 * @see Command
 * @see SystemCommand
 */
class Game implements Commanded {

    private final InhabitedWorld world;

    private final ExistingCharacter hero;

    Game() {
        world = new WhiteCube();

        hero = new Human(new Name("Billy", "Bob", "Norris"), world) {
            @Override
            public Optional<Result> handle(Command command) {
                System.out.println(command);
                return Optional.empty();
            }
        };
    }

    Character hero() {
        return hero;
    }

    @Override
    public Optional<Result> handle(Command command) {
        if (command instanceof Exit) {
            System.exit(0);
        } else if (command instanceof None) {
            return Optional.of(
                    new Error(String.format("Nonesuch command %s",
                            ((None) command).input())));
        }
        return Optional.of(new Error("Nonesuch command"));
    }
}
