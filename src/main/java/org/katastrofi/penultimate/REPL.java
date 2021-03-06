package org.katastrofi.penultimate;

import java.io.Console;


/**
 * REPL, a text-based interface to the game.
 * <p>
 * A parser is used to parse input to commands and command results to
 * potential output.
 *
 * @see ParsingInterface
 */
public class REPL extends ParsingInterface<String, String> {

    private final Console console;

    REPL(Console console, Parser<String, String> parser,
         ChainOfCommand chainOfCommand) {
        super(parser, chainOfCommand);
        this.console = console;
    }

    void run() {
        do {
            handle(console.readLine("Say what? >> ")).stream()
                    .forEach(System.out::println);
        } while (true);
    }
}
