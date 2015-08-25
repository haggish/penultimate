package org.katastrofi.penultimate;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.katastrofi.penultimate.Collections.listOf;

public class ParsingInterfaceTest {

    private ParsingInterface<String, String> instance;

    private Parser<String, String> parser;

    private ChainOfCommand chainOfCommand;

    private String expectedOutput = "expected";

    private Command parsedCommand = new TestData.TestCommand();

    private TestData.TestResult expectedResult = new TestData.TestResult();

    @Before
    public void init() {
        parser = new Parser<String, String>() {
            @Override
            public Command commandFrom(String input) {
                return parsedCommand;
            }

            @Override
            public String outputFrom(Result result) {
                if (result.equals(expectedResult)) {
                    return expectedOutput;
                } else {
                    return null;
                }
            }
        };
        chainOfCommand = command -> listOf(expectedResult);
        instance = new ParsingInterface<>(parser, chainOfCommand);
    }

    @Test
    public void
    handlingInputMakesGivenChainOfCommandActOutCommandParsedFromInputByGivenParserAndReturnsResultsParsedByGivenParser() {
        assertThat(instance.handle("in"), contains(expectedOutput));
    }
}
