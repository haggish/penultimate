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
        return "Move to " + direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Move move = (Move) o;

        return direction == move.direction;

    }

    @Override
    public int hashCode() {
        return direction.hashCode();
    }
}
