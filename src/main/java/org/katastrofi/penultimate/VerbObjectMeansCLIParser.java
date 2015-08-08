package org.katastrofi.penultimate;

import java.util.Map;
import java.util.function.Supplier;

/**
 * Verb-object-means-CLI-parser is a string-based parser which expects the
 * input to be in the form where the first word is a verb, potential second
 * one is an object and the rest is a refinement of means to carry out the
 * command, e.g. "hit orc with hammer".
 *
 * @see ChainOfCommand
 * @see Parser
 */
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

        return commandFactoriesByVerbs
                .getOrDefault(verb, () -> new None<>(input))
                .get();

    }

    @Override
    public String outputFrom(Result result) {
        return result.toString();
    }
}
