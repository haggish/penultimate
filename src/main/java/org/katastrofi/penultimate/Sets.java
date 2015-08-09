package org.katastrofi.penultimate;

import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.addAll;

/**
 * Set utils.
 */
public class Sets {

    private Sets() {
    }

    static <T> Set<T> setOf(T... ts) {
        Set<T> set = new HashSet<>();
        addAll(set, ts);
        return set;
    }
}
