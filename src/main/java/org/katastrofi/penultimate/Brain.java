package org.katastrofi.penultimate;

import static java.util.stream.Collectors.toSet;

import java.util.HashSet;
import java.util.Set;


/**
 * Brain, i.e. character's ability to react to commands.
 */
class Brain {

    private final Character owner;

    private final Set<Skill> skillSet = new HashSet<>();

    Brain(Character character) {
        this.owner = character;
    }

    Set<Result> process(Command command) {
        return skillSet.stream()
                .filter(s -> s.trigger().test(command))
                .map(Skill::action)
                .flatMap(a -> a.apply(command, owner).stream())
                .collect(toSet());
    }

    void learn(Skill skill) {
        skillSet.add(skill);
    }

    Boolean isSkilledAt(Skill skill) {
        return skillSet.contains(skill);
    }
}
