package org.katastrofi.penultimate;

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

    abstract O voidValue();

    Parser<I, O> parser() {
        return parser;
    }

}
