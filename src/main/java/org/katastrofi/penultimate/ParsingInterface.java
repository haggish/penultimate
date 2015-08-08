package org.katastrofi.penultimate;

/**
 * An interface that uses the Parser component to parse input into commands.
 *
 * @see Parser
 * @see Interface
 */
abstract class ParsingInterface<I, O> implements Interface<I, O> {

    private final Parser<I, O> parser;

    private final ChainOfCommand chainOfCommand;

    ParsingInterface(Parser<I, O> parser, ChainOfCommand chainOfCommand) {
        this.parser = parser;
        this.chainOfCommand = chainOfCommand;
    }

    @Override
    public O handle(I input) {
        Command command = parser.commandFrom(input);
        return chainOfCommand.handle(command)
                .map(parser::outputFrom)
                .orElse(voidValue());
    }

    /**
     * @return output that signifies missing output
     */
    abstract O voidValue();

    Parser<I, O> parser() {
        return parser;
    }

}
