package org.katastrofi.penultimate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Two-dimensional sparse matrix.
 */
class SparseMatrix<T> {

    private final Map<XYCoordinates, T> elements = new HashMap<>();

    T get(XYCoordinates c) {
        return elements.get(c);
    }

    void set(XYCoordinates c, T element) {
        elements.put(c, element);
    }

    Set<XYCoordinates> coordinates() {
        return elements.keySet();
    }
}
