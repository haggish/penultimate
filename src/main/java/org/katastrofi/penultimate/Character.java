package org.katastrofi.penultimate;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static java.util.Collections.unmodifiableList;

/**
 * Identifiable character that exists somewhere and acts in various ways.
 */
abstract class Character extends Thing implements Commanded {

    private EventHistory history = new EventHistory();

    private Possessions possessions = new Possessions();

    private Brain brain;

    private Condition condition;

    Character(World world, Condition condition) {
        super(world);
        this.brain = new Brain(this);
        this.condition = condition;
    }

    Character(World world, Location location, Condition condition) {
        super(world, location);
        this.brain = new Brain(this);
        this.condition = condition;
    }

    Brain brain() {
        return brain;
    }

    EventHistory history() {
        return history;
    }

    Condition condition() {
        return condition;
    }

    public List<Result> actOut(Command command) {
        return brain.process(command);
    }

    void learn(Skill skill) {
        brain.learn(skill);
    }

    @Override
    public String toString() {
        return "ExistingActingCharacter{" +
                "history=" + history +
                '}';
    }

    void take(Thing thing) {
        possessions.add(thing);
    }

    @Override
    Set<Result> tick() {
        return condition.age();
    }

    List<Thing> inventory() {
        return possessions.inventory();
    }

    Boolean isSkilledAt(Skill skill) {
        return brain().isSkilledAt(skill);
    }

    void drop(Thing thing) {
        possessions.remove(thing);
    }

    static class EventHistory {
        private LinkedList<Event> history = new LinkedList<>();

        public void push(Event event) {
            history.addFirst(event);
            if (history.size() > 10) {
                history.removeLast();
            }
        }

        List<Event> get() {
            return unmodifiableList(history);
        }
    }
}
