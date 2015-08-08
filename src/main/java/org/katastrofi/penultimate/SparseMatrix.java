package org.katastrofi.penultimate;

import java.util.HashMap;
import java.util.Map;

/**
 * Two-dimensional sparse matrix.
 */
class SparseMatrix<T> {

    private final Map<Coordinate, T> elements = new HashMap<>();

    T get(Coordinate c) {
        return elements.get(c);
    }

    void set(Coordinate c, T element) {
        elements.put(c, element);
    }

    static class Coordinate {

        private final int x, y;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        static Coordinate coord(int x, int y) {
            return new Coordinate(x, y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Coordinate)) return false;

            Coordinate that = (Coordinate) o;

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
}
