package org.katastrofi.penultimate;

import java.io.Console;

public class DefaultParser implements Parser {

    @Override
    public Command commandFrom(Console console) {
        String input = console.readLine("Say what? >> ");

        String commandString = input.split(" ", 1)[0];

        if ("exit".equals(commandString)) {
            return new Exit(input);
        } else {
            return new None(input);
        }
    }
}
