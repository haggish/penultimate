package org.katastrofi.penultimate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static org.katastrofi.penultimate.Direction.EAST;
import static org.katastrofi.penultimate.Direction.NORTH;
import static org.katastrofi.penultimate.Direction.NORTHEAST;
import static org.katastrofi.penultimate.Direction.NORTHWEST;
import static org.katastrofi.penultimate.Direction.SOUTH;
import static org.katastrofi.penultimate.Direction.SOUTHEAST;
import static org.katastrofi.penultimate.Direction.SOUTHWEST;
import static org.katastrofi.penultimate.Direction.WEST;

public class Main {

    public static void main(String args[]) {

        Game game = new Game();

        Parser<String, String> parser =
                new VerbObjectMeansCLIParser(commandMappings());

        ChainOfCommand chainOfCommand =
                new SystemCharacterChainOfCommand(game);

        new CLI(System.console(), parser, chainOfCommand).run();

    }


    private static Map<String, Supplier<Command>> commandMappings() {
        Map<String, Supplier<Command>> commandMappings = new HashMap<>();
        commandMappings.put("exit", Exit::new);
        commandMappings.put("n", () -> Move.to(NORTH));
        commandMappings.put("s", () -> Move.to(SOUTH));
        commandMappings.put("e", () -> Move.to(EAST));
        commandMappings.put("w", () -> Move.to(WEST));
        commandMappings.put("ne", () -> Move.to(NORTHEAST));
        commandMappings.put("se", () -> Move.to(SOUTHEAST));
        commandMappings.put("sw", () -> Move.to(SOUTHWEST));
        commandMappings.put("nw", () -> Move.to(NORTHWEST));
        commandMappings.put("take", Exit::new); // TODO parameters?
        return commandMappings;
    }
}
