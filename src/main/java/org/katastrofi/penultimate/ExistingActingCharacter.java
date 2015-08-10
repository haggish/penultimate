package org.katastrofi.penultimate;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static java.util.Collections.unmodifiableList;

/**
 * Identifiable character that exists somewhere and acts in various ways.
 */
abstract class ExistingActingCharacter
        extends ExistingIdentifiableThing implements Character {

    private ActionHistory history = new ActionHistory();

    private Possessions possessions = new Possessions();

    private Brain brain;

    ExistingActingCharacter(World world) {
        super(world);
        this.brain = new Brain(this);
    }

    Brain brain() {
        return brain;
    }

    ActionHistory history() {
        return history;
    }

    public Set<Result> actOut(Command command) {
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

    public void take(Thing thing) {
        possessions.add(thing);
    }

    static class ActionHistory {
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
