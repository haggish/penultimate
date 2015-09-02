package org.katastrofi.penultimate;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Function utils.
 */
public class Functions {

    static <T> Function<T, T> tap(Consumer<T> sideEffect) {
        return t -> {
            sideEffect.accept(t);
            return t;
        };
    }

}
