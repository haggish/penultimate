package org.katastrofi.penultimate;

import java.util.Optional;

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
