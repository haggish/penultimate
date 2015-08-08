package org.katastrofi.penultimate;

/**
 * Command to move into some direction.
 */
public class Move implements Command {

    private final Direction direction;

    Move(Direction direction) {
        this.direction = direction;
    }

}
