package org.katastrofi.penultimate;

import static org.katastrofi.penultimate.Direction.EAST;
import static org.katastrofi.penultimate.Direction.NORTH;
import static org.katastrofi.penultimate.Direction.NORTHEAST;
import static org.katastrofi.penultimate.Direction.NORTHWEST;
import static org.katastrofi.penultimate.Direction.SOUTH;
import static org.katastrofi.penultimate.Direction.SOUTHEAST;
import static org.katastrofi.penultimate.Direction.SOUTHWEST;
import static org.katastrofi.penultimate.Direction.WEST;
import static org.katastrofi.penultimate.VerbObjectMeansCLIParser.objectFrom;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


public class Main {

    public static void main(String args[]) {

        World world = new WhiteCube();

        ExistingActingCharacter hero =
                new Human(new Name("Billy", "Bob", "Norris"), world);
        new Stone(world);

        Game game = new Game(hero);

        Parser<String, String> parser =
                new VerbObjectMeansCLIParser(new CommandMappings().get());

        ChainOfCommand chainOfCommand =
                new SystemCharacterChainOfCommand(game);

        new CLI(System.console(), parser, chainOfCommand).run();

    }
}
