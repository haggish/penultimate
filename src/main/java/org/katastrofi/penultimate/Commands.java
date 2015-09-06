package org.katastrofi.penultimate;

/**
 * Singleton commands.
 */
public class Commands {

    static final Command EXIT = new DescribedSystemCommand("exit");

    static final Command INVENTORY = new DescribedSystemCommand("inventory") {
    };

    static final Command INIT = new DescribedSystemCommand("initialization");

    static final Command PLAY = new DescribedSystemCommand("play");

    static class DescribedSystemCommand implements SystemCommand {

        private final String desc;

        DescribedSystemCommand(String desc) {
            this.desc = desc;
        }

        @Override
        public String toString() {
            return desc;
        }
    }

}
