package org.katastrofi.penultimate;

/**
 * Command is a command (usually by the player) to the game to do something.
 *
 * It is distributed by the chain of command to, for example, the game for
 * administrative commands like i or exit, or to player's character (Hero)
 * to do something.
 *
 * @see Game
 * @see Hero
 * @see ChainOfCommand
 */
interface Command {
}
