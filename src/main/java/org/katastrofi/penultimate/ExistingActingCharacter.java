package org.katastrofi.penultimate;

import java.util.LinkedList;
import java.util.Set;

/**
 * Identifiable character that exists somewhere and acts in various ways.
 */
abstract class ExistingActingCharacter<T extends Location<T>>
        extends ExistingIdentifiableThing<T> implements Character {

    private ActionHistory history = new ActionHistory();

    private Brain<T> brain;

    ExistingActingCharacter(InhabitedWorld<T> world) {
        super(world);
        this.brain = new Brain<T>(this);
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

    static class ActionHistory {
        private LinkedList<Event> history = new LinkedList<>();

        public void push(Event event) {
            history.addFirst(event);
            if (history.size() > 10) {
                history.removeLast();
            }
        }
    }
}
