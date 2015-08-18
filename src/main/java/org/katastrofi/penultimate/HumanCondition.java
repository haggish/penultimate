package org.katastrofi.penultimate;

import java.util.HashSet;
import java.util.Set;

import static java.lang.String.format;

/**
 * Condition of a character.
 */
class HumanCondition implements Condition {

    private Long age;

    private Integer hitPoints;

    private Integer hunger;

    private Integer thirst;

    private Integer sleepiness;

    HumanCondition(Integer initialHitPoints) {
        age = 0L;
        hitPoints = initialHitPoints;
        hunger = thirst = sleepiness = 0;
    }

    public Set<Result> age() {
        age++;
        if (age % 4 == 0) {
            hitPoints--;
            hunger++;
            sleepiness++;
        }
        if (age % 2 == 0) {
            thirst++;
        }

        Set<Result> results = new HashSet<>();

        if (hitPoints < 20) {
            results.add(new Warning("The hero feels weak!"));
        }

        if (hunger > 20) {
            results.add(new Warning("The hero is hungry!"));
        }

        if (thirst > 20) {
            results.add(new Warning("The hero needs something to drink!"));
        }

        if (sleepiness > 20) {
            results.add(new Warning("The hero is sleepy..."));
        }

        return results;
    }

    public String toString() {
        return format("[HP:%s][Hu:%s][Th:%s][Sl:%s]",
                hitPoints, hunger, thirst, sleepiness);
    }
}
