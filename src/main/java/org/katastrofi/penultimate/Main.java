package org.katastrofi.penultimate;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Main {

    public static void main(String args[]) {

        World world = new WhiteCube();

        Character hero =
                new Human(new Name("Billy", "Bob", "Norris"), world);
        new Stone(world, hero.location());

        Map<Game.Phase, Set<SystemAction>> commands = new HashMap<>();

        commands.putAll(StartControl.get());
        commands.putAll(CharacterBuildingControl.get());
        commands.putAll(MainGameControl.get());
        commands.putAll(GenericControl.get());

        Game game = new Game(hero, commands);

        Parser<String, String> parser =
                new VerbObjectMeansREPLParser(new CommandMappings().get());

        ChainOfCommand chainOfCommand =
                new SystemCharacterChainOfCommand(game);

        new REPL(System.console(), parser, chainOfCommand).run();

    }
}
