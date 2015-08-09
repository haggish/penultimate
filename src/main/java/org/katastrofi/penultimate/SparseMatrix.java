package org.katastrofi.penultimate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Two-dimensional sparse matrix.
 */
class SparseMatrix<T> {

    private final Map<TwoDimensionalCoordinates, T> elements = new HashMap<>();

    T get(TwoDimensionalCoordinates c) {
        return elements.get(c);
    }

    void set(TwoDimensionalCoordinates c, T element) {
        elements.put(c, element);
    }

    Set<TwoDimensionalCoordinates> coordinates() {
        return elements.keySet();
    }
}
