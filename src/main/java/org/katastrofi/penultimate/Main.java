package org.katastrofi.penultimate;

import java.util.Optional;

public class Main {

    public static void main(String args[]) {
        new CLI(System.console(), new CLIParser(),
                new SystemCharacterChainOfCommand(new Game(), command -> {
                    System.out.println(command);
                    return Optional.empty();
                }))
                .run();
    }
}
