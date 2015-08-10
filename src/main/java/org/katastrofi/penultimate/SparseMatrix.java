package org.katastrofi.penultimate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * Two-dimensional sparse matrix.
 */
class SparseMatrix<T> {

    private final Map<Location, T> elements = new HashMap<>();

    T get(Location c) {
        return elements.get(c);
    }

    void set(Location c, T element) {
        elements.put(c, element);
    }

    Set<Location> coordinates() {
        return elements.keySet();
    }
}
