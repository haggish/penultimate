package org.katastrofi.penultimate;

import java.util.Optional;

/**
 * A chain of command, which distinguishes two types of commands; commands to
 * player's character and commands to the system.
 *
 * System commands are handled by the Game, whereas player's character (Hero)
 * handles the regular commands like go west.
 *
 * @see Command
 * @see SystemCommand
 * @see Game
 * @see Hero
 */
class SystemCharacterChainOfCommand implements ChainOfCommand {

    private Game game;

    private Hero hero;

    SystemCharacterChainOfCommand(Game game, Hero hero) {
        this.game = game;
        this.hero = hero;
    }

    @Override
    public Optional<Result> handle(Command command) {
        if (command instanceof SystemCommand) {
            return game.handle(command);
        } else {
            return hero.handle(command);
        }
    }
}
