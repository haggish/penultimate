package org.katastrofi.penultimate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;


/**
 * Brain, i.e. character's ability to react to commands.
 */
class Brain {

    private final Character owner;

    private final Set<Skill> skillSet = new HashSet<>();

    Brain(Character character) {
        this.owner = character;
    }

    List<Result> process(Command command) {
        return skillSet.stream()
                .filter(s -> s.trigger().test(command))
                .map(Skill::action)
                .flatMap(a -> a.apply(command, owner).stream())
                .collect(toList());
    }

    void learn(Skill skill) {
        skillSet.add(skill);
    }

    Boolean isSkilledAt(Skill skill) {
        return skillSet.contains(skill);
    }
}
