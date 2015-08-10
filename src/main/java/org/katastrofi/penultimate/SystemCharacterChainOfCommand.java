package org.katastrofi.penultimate;

import java.util.Set;


/**
 * A chain of command, which distinguishes two types of commands; commands to
 * player's character and commands to the system.
 * <p>
 * System commands are handled by the Game, whereas player's character (Hero)
 * handles the regular commands like go west.
 *
 * @see Command
 * @see SystemCommand
 * @see Game
 * @see Hero
 */
class SystemCharacterChainOfCommand implements ChainOfCommand {

    private final Game game;

    SystemCharacterChainOfCommand(Game game) {
        this.game = game;
    }

    @Override
    public Set<Result> actOut(Command command) {
        if (command instanceof SystemCommand) {
            return game.actOut(command);
        } else {
            return game.hero().actOut(command);
        }
    }
}
