package org.katastrofi.penultimate;

import java.util.Set;

import static org.katastrofi.penultimate.Movement.movementTo;
import static org.katastrofi.penultimate.Sets.setOf;

/**
 * Human character.
 */
class Human<T extends Location> extends NamedCharacter<T> {

    Human(Name name, InhabitedWorld<T> world) {
        super(name, world);
    }

    @Override
    public Set<Result> actOut(Command command) {
        if (command instanceof Move) {
            Direction direction = ((Move) command).direction();
            makeHappen(movementTo(direction, this));
            return setOf(new Info("Moving to " + direction));
        }
        System.out.println(command);
        return setOf();
    }
}
