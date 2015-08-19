package org.katastrofi.penultimate;

import static java.util.stream.Collectors.toSet;
import static org.katastrofi.penultimate.Event.TICK;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;


/**
 * Action executed by a character.
 * <p/>
 * Action is how a character reacts to a command and what results from it in
 * its world.
 * <p/>
 * Action consists of its "meat", which is what essentially happens, and
 * administrative stuff: events that the "meat" produces are emitted to the
 * world and saved into character's action history.
 */
class Action implements BiFunction<Command, Character, Set<Result>> {

    private final BiFunction<Command, Character, Set<Event>>
            eventProducer;

    private final BiConsumer<Set<Event>, Character> meat;

    Action(BiFunction<Command, Character,
            Set<Event>> eventProducer,
           BiConsumer<Set<Event>, Character> meat) {
        this.eventProducer = eventProducer;
        this.meat = meat;
    }

    @Override
    public Set<Result> apply(Command command, Character character) {

        Set<Event> events = eventProducer.apply(command, character);
        Set<Result> results = events.stream()
                .flatMap(e -> character.world().experience(e).stream())
                .collect(toSet());
        if (ok(results)) {
            meat.accept(events, character);
            events.stream().forEach(e -> character.history().push(e));
        }
        return results;

    }

    private Boolean ok(Set<Result> results) {
        return results.stream().noneMatch(r -> r instanceof Error);
    }
}
