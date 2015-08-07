package org.katastrofi.penultimate;

import java.util.Map;
import java.util.function.Supplier;

public class VerbObjectMeansCLIParser implements Parser<String, String> {

    private Map<String, Supplier<Command>> commandFactoriesByVerbs;

    VerbObjectMeansCLIParser(
            Map<String, Supplier<Command>> commandFactoriesByVerbs) {
        this.commandFactoriesByVerbs = commandFactoriesByVerbs;
    }

    @Override
    public Command commandFrom(String input) {

        String[] fragments = input.split(" ", 1);
        String verb = fragments[0];

        return commandFactoriesByVerbs.getOrDefault(verb, () -> new None(input))
                .get();

    }

    @Override
    public String outputFrom(Result result) {
        return result.toString();
    }
}
