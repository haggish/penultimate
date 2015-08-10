package org.katastrofi.penultimate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;


/**
 * World that is inhabited and has some laws of nature.
 */
class World {

    private final Terrain terrain;

    private final Map<String, ExistingIdentifiableThing> thingsByIDs =
            new HashMap<>();

    private final Map<Predicate<Event>,
            BiFunction<Event, World, List<Result>>>
            lawsOfNature = new HashMap<>();

    World(Terrain terrain) {
        this.terrain = terrain;
    }

    /**
     * Add a thing to world.
     *
     * @param thing added thing
     */
    void add(ExistingIdentifiableThing thing) {
        thingsByIDs.put(thing.id(), thing);
    }

    Location randomLocationOf(
            Class<? extends TerrainFragment> terrainType) {
        return terrain.pickRandomCoordinatesOf(terrainType);
    }

    Terrain terrain() {
        return terrain;
    }

    public List<Result> experience(Event event) {
        return lawsOfNature.keySet().stream()
                .filter(t -> t.test(event))
                .map(lawsOfNature::get)
                .flatMap(l -> l.apply(event, this).stream())
                .collect(toList());
    }

    void declare(Predicate<Event> circumstances,
                 BiFunction<Event, World, List<Result>>
                         lawOfNature) {
        lawsOfNature.put(circumstances, lawOfNature);
    }

    Set<ExistingIdentifiableThing> thingsAt(Location location) {
        return thingsByIDs.values().stream()
                .filter(eit -> eit.location().equals(location))
                .collect(toSet());
    }

    Optional<ExistingIdentifiableThing> thingByNameAndPlace(String name, Location place) {
        return thingsAt(place).stream()
                .filter(t -> t.genericName().equals(name))
                .findFirst();
    }
}
