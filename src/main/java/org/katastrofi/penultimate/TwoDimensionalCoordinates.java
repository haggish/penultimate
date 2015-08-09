package org.katastrofi.penultimate;

/**
 * Two dimensional whole number coordinates.
 */
class TwoDimensionalCoordinates implements Location {

    private final int x, y;

    private TwoDimensionalCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static TwoDimensionalCoordinates coord(int x, int y) {
        return new TwoDimensionalCoordinates(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TwoDimensionalCoordinates)) return false;

        TwoDimensionalCoordinates that = (TwoDimensionalCoordinates) o;

        if (x != that.x) return false;
        return y == that.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
