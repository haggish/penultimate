package org.katastrofi.penultimate;

import java.util.HashSet;
import java.util.Set;


/**
 * Variety of things a character carries.
 */
class Possessions {

    private Set<Thing> things = new HashSet<>();

    void add(Thing thing) {
        things.add(thing);
    }

}
