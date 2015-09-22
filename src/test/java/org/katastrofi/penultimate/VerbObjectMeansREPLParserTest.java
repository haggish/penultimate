package org.katastrofi.penultimate;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.katastrofi.penultimate.VerbObjectMeansREPLParser.fragmentFrom;
import static org.katastrofi.penultimate.VerbObjectMeansREPLParser.objectFrom;
import static org.katastrofi.penultimate.VerbObjectMeansREPLParser.verbFrom;

public class VerbObjectMeansREPLParserTest {

    private VerbObjectMeansREPLParser instance;

    private Command expectedCommand = new TestData.TestCommand();

    private String inputReceivedByCommand;

    private String inputVerb = "cmd", wholeInput = inputVerb + " bababa";

    @Before
    public void init() {
        Map<String, Function<String, Command>> commandMap = new HashMap<>();
        commandMap.put(inputVerb, s -> {
            inputReceivedByCommand = s;
            return expectedCommand;
        });
        instance = new VerbObjectMeansREPLParser(commandMap);
    }

    @Test
    public void
    commandFromInputIsCommandFunctionMappedByVerbOfInputAppliedToWholeInput() {
        assertThat(instance.commandFrom(wholeInput), is(expectedCommand));
        assertThat(inputReceivedByCommand, is(wholeInput));
    }

    @Test
    public void commandFromInputIsNoneIfNoCommandMapsToVerbOfInput() {
        assertThat(instance.commandFrom("nonesuch"),
                is(new None<>("nonesuch")));
    }

    @Test
    public void outputOfResultIsResultToString() {
        assertThat(instance.outputFrom(new Result() {
            @Override
            public String toString() {
                return "bob";
            }
        }), is("bob"));
    }

    @Test
    public void verbFromInputIsFirstSpaceSeparatedFragment() {
        assertThat(verbFrom("cmd obj"), is("cmd"));
    }

    @Test
    public void objectFromInputIsSecondSpaceSeparatedFragment() {
        assertThat(objectFrom("cmd obj"), is("obj"));
    }

    @Test
    public void nthFragmentFromInputIsNthSpaceSeparatedFragment() {
        assertThat(fragmentFrom("cmd obj", 2), is("obj"));
    }

    @Test
    public void nonExistentFragmentIndexFromInputIsNull() {
        assertThat(fragmentFrom("cmd obj", 3), is(nullValue()));
    }
}
