package org.katastrofi.penultimate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

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
        commandMappings.put("n", Exit::new);
        commandMappings.put("s", Exit::new);
        commandMappings.put("e", Exit::new);
        commandMappings.put("w", Exit::new);
        commandMappings.put("ne", Exit::new);
        commandMappings.put("se", Exit::new);
        commandMappings.put("sw", Exit::new);
        commandMappings.put("nw", Exit::new);
        commandMappings.put("take", Exit::new);
        return commandMappings;
    }
}
