package org.katastrofi.penultimate;

/**
 * Interface is an interface between the game and player.
 *
 * Currently it is command line / String based but it could be a JSON-
 * based REST endpoint, a TCP socket, or something else.
 *
 * @param <I> type of input
 * @param <O> type of output
 */
interface Interface<I,O> {

    /**
     * @param input one input by player
     * @return result of input to the game
     */
    O handle(I input);

}
