package org.katastrofi.penultimate;

import java.io.Console;

public class CLI {

    private final Console console;

    private final Parser parser;

    CLI(Console console, Parser parser) {
        this.console = console;
        this.parser = parser;
    }

    void run() {
        do {
            parser.commandFrom(console).execute();
        } while (true);
    }
}
