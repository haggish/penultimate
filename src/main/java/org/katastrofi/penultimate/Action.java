package org.katastrofi.penultimate;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import static java.util.stream.Collectors.toSet;

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
class Action<T extends Location<T>>
        implements
        BiFunction<Command, ExistingActingCharacter<T>, Set<Result>> {

    private final BiFunction<Command, ExistingActingCharacter<T>, Set<Event>>
            eventProducer;

    private final BiConsumer<Command, ExistingActingCharacter<T>> meat;

    Action(BiFunction<Command, ExistingActingCharacter<T>,
            Set<Event>> eventProducer,
           BiConsumer<Command, ExistingActingCharacter<T>> meat) {
        this.eventProducer = eventProducer;
        this.meat = meat;
    }

    @Override
    public Set<Result> apply(Command command,
                             ExistingActingCharacter<T> character) {
        Set<Event> events = eventProducer.apply(command, character);
        Set<Result> results = events.stream()
                .flatMap(e -> character.world().experience(e).stream())
                .collect(toSet());
        if (ok(results)) {
            meat.accept(command, character);
            events.stream().forEach(e -> character.history().push(e));
        }
        return results;
    }

    private Boolean ok(Set<Result> results) {
        return results.stream().noneMatch(r -> r instanceof Error);
    }
}
