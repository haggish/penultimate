package org.katastrofi.penultimate;

import java.util.ArrayList;
import java.util.List;

/**
 * Persistence by serialization to the file system.
 */
public class SerialPersistence implements Persistence {

    @Override
    public List<Character> characters() {
        List<Character> characters = new ArrayList<>();
        //characters.add(new Human(new Name("Hank", "Bobby", "Nash"), world, location))
        return characters; // TODO
    }
}
