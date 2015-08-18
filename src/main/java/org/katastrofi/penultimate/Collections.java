package org.katastrofi.penultimate;

import static java.util.Collections.addAll;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Set utils.
 */
public class Collections {

    private Collections() {
    }

    static <T> Set<T> setOf(T... ts) {
        Set<T> set = new HashSet<>();
        addAll(set, ts);
        return set;
    }

    static <T> List<T> listOf(T... ts) {
        List<T> list = new ArrayList<>();
        addAll(list, ts);
        return list;
    }

    static <T> List<T> combined(List<T>... tss) {
        // TODO
        return null;
    }
}
