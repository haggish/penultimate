package org.katastrofi.penultimate;

public class CLIParser implements Parser<String, String> {

    @Override
    public Command commandFrom(String input) {

        String commandString = input.split(" ", 1)[0];

        if ("exit".equals(commandString)) {
            return new Exit();
        } else {
            return new None(input);
        }
    }

    @Override
    public String outputFrom(Result result) {
        return result.toString();
    }
}
