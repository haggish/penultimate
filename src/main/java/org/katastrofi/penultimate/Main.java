package org.katastrofi.penultimate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class Main {

    public static void main(String args[]) {

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

        new CLI(System.console(), new VerbObjectMeansCLIParser(commandMappings),
                new SystemCharacterChainOfCommand(new Game(), command -> {
                    System.out.println(command);
                    return Optional.empty();
                }))
                .run();
    }
}
