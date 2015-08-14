package org.katastrofi.penultimate;

import static java.util.stream.Collectors.toSet;
import static org.katastrofi.penultimate.Collections.setOf;
import static org.katastrofi.penultimate.Commands.EXIT;
import static org.katastrofi.penultimate.Commands.INVENTORY;

import java.util.Set;
import java.util.stream.Collectors;


/**
 * Game is the main application class that handles the system commands.
 *
 * @see Command
 * @see SystemCommand
 */
class Game implements Commanded {

    private final Character hero;

    Game(Character hero) {
        this.hero = hero;
    }

    Character hero() {
        return hero;
    }

    @Override
    public Set<Result> actOut(Command command) {
        if (command.equals(EXIT)) {
            System.exit(0);
        } else if (command.equals(INVENTORY)) {
            return hero().inventory().stream()
                    .map(t -> new Info(t.genericName()))
                    .collect(toSet());
        } else if (command instanceof None) {
            return setOf(new Error(String.format("Nonesuch command %s",
                    ((None) command).input())));
        }
        return setOf(new Error("Nonesuch command"));
    }
}
