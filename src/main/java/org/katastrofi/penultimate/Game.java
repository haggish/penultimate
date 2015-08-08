package org.katastrofi.penultimate;

import java.util.Optional;

/**
 * Game is the main application class that handles the system commands.
 *
 * @see Command
 * @see SystemCommand
 */
class Game implements Commanded {
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
