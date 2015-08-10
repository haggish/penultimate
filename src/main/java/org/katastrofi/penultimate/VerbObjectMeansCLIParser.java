package org.katastrofi.penultimate;

import java.util.Map;
import java.util.function.Function;


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

    private Map<String, Function<String, Command>> commandParsersByVerbs;

    VerbObjectMeansCLIParser(
            Map<String, Function<String, Command>> commandParsersByVerbs) {
        this.commandParsersByVerbs = commandParsersByVerbs;
    }

    @Override
    public Command commandFrom(String input) {

        return commandParsersByVerbs
                .getOrDefault(verbFrom(input), None::new)
                .apply(input);

    }

    @Override
    public String outputFrom(Result result) {
        return result.toString();
    }

    static String objectFrom(String input) {
        return fragmentFrom(input, 2);
    }

    static String verbFrom(String input) {
        return fragmentFrom(input, 1);
    }

    static String fragmentFrom(String input, int index) {
        String[] fragments = input.split(" ", 1);
        if (index > 0 && index < fragments.length) {
            return fragments[index - 1];
        } else {
            return null;
        }
    }
}
