package org.katastrofi.penultimate;

import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * Brain, i.e. character's ability to react to commands.
 */
class Brain<T extends Location> {

    private final ExistingActingCharacter<T> owner;

    private final Set<Skill<T>> skillSet = new HashSet<>();

    Brain(ExistingActingCharacter<T> character) {
        this.owner = character;
    }

    Set<Result> process(Command command) {
        return skillSet.stream()
                .filter(s -> s.trigger().test(command))
                .flatMap(s -> s.action().execute(command, owner).stream())
                .collect(toSet());
    }

    void learn(Skill<T> skill) {
        skillSet.add(skill);
    }
}
