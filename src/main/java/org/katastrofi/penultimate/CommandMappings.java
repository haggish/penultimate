package org.katastrofi.penultimate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static org.katastrofi.penultimate.Commands.EXIT;
import static org.katastrofi.penultimate.Direction.EAST;
import static org.katastrofi.penultimate.Direction.NORTH;
import static org.katastrofi.penultimate.Direction.NORTHEAST;
import static org.katastrofi.penultimate.Direction.NORTHWEST;
import static org.katastrofi.penultimate.Direction.SOUTH;
import static org.katastrofi.penultimate.Direction.SOUTHEAST;
import static org.katastrofi.penultimate.Direction.SOUTHWEST;
import static org.katastrofi.penultimate.Direction.WEST;
import static org.katastrofi.penultimate.VerbObjectMeansCLIParser.objectFrom;

/**
 * String-to-Command mappings.
 */
class CommandMappings {

    Map<String, Function<String, Command>> get() {
        Map<String, Function<String, Command>> commandMappings = new HashMap<>();
        commandMappings.put("exit", (in) -> EXIT);
        commandMappings.put("n", (in) -> Move.to(NORTH));
        commandMappings.put("s", (in) -> Move.to(SOUTH));
        commandMappings.put("e", (in) -> Move.to(EAST));
        commandMappings.put("w", (in) -> Move.to(WEST));
        commandMappings.put("ne", (in) -> Move.to(NORTHEAST));
        commandMappings.put("se", (in) -> Move.to(SOUTHEAST));
        commandMappings.put("sw", (in) -> Move.to(SOUTHWEST));
        commandMappings.put("nw", (in) -> Move.to(NORTHWEST));
        commandMappings.put("take", (in) -> new Take(objectFrom(in)));
        return commandMappings;
    }
}
