package org.katastrofi.penultimate;

/**
 * Parser that parses an input to a command and its result to an output.
 *
 * @param <I> type of input
 * @param <O> type of output
 */
interface Parser<I,O> {

    /**
     * @param input given input
     * @return command from the input
     */
    Command commandFrom(I input);

    /**
     * @param result given result
     * @return output from the result
     */
    O outputFrom(Result result);

}
