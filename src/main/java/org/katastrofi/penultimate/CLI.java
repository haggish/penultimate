package org.katastrofi.penultimate;

import java.io.Console;

public class CLI extends ParsingInterface<String, String> {

    private final Console console;

    CLI(Console console, Parser<String, String> parser,
        ChainOfCommand chainOfCommand) {
        super(parser, chainOfCommand);
        this.console = console;
    }

    void run() {
        do {
            System.out.println(handle(console.readLine("Say what? >> ")));
        } while (true);
    }

    @Override
    String voidValue() {
        return "";
    }
}
