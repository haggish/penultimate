package org.katastrofi.penultimate;


public class Main {

    public static void main(String args[]) {

        World world = new WhiteCube();

        Character hero =
                new Human(new Name("Billy", "Bob", "Norris"), world);
        new Stone(world, hero.location());

        Game game = new Game(hero, MainGameControl.get());

        Parser<String, String> parser =
                new VerbObjectMeansCLIParser(new CommandMappings().get());

        ChainOfCommand chainOfCommand =
                new SystemCharacterChainOfCommand(game);

        new CLI(System.console(), parser, chainOfCommand).run();

    }
}
