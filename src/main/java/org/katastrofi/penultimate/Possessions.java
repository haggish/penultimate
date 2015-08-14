package org.katastrofi.penultimate;

import java.util.*;

import static java.util.Collections.unmodifiableList;


/**
 * Variety of things a character carries.
 */
class Possessions {

    private List<Thing> things = new ArrayList<>();

    void add(Thing thing) {
        things.add(thing);
    }

    void remove(Thing thing) {
        things.remove(thing);
    }

    public List<Thing> inventory() {
        return unmodifiableList(things);
    }
}
