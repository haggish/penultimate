package org.katastrofi.penultimate;

/**
 * Command to move into some direction.
 */
public class Move implements Command {

    private final Direction direction;

    private Move(Direction direction) {
        this.direction = direction;
    }

    static Move to(Direction direction) {
        return new Move(direction);
    }

    Direction direction() {
        return direction;
    }

    @Override
    public String toString() {
        return "Move{" +
                "direction=" + direction +
                '}';
    }
}
