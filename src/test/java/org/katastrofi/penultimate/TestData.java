package org.katastrofi.penultimate;

import java.util.Collections;

import static org.katastrofi.penultimate.Location.coord;

class TestData {

    static World oneFloor() {
        SparseMatrix<TerrainFragment> map = new SparseMatrix<>();
        map.set(coord(1, 1), new Floor());
        return new World(new Terrain(map));
    }

    static World twoFloors() {
        SparseMatrix<TerrainFragment> map = new SparseMatrix<>();
        map.set(coord(1, 1), new Floor());
        map.set(coord(1, 2), new Floor());
        return new World(new Terrain(map));
    }

    static Human humanIn(World world) {
        return new Human(new Name("Bob", null, null), world);
    }

    static Human humanIn(World world, Location location) {
        return new Human(new Name("Bob", null, null), world, location);
    }

    static class TestEvent implements Event {
        final Command c;
        final Character ch;

        TestEvent(Command c, Character ch) {
            this.c = c;
            this.ch = ch;
        }
    }

    static class TestCommand implements Command {
    }

    static class NOPAction extends Action {
        NOPAction() {
            super((c, ch) -> Collections.<Event>emptySet(),
                    (c, ch) -> ch.toString()); // whatever
        }
    }

    static class TestResult implements Result {
    }
}
