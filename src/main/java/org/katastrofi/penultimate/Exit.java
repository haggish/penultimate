package org.katastrofi.penultimate;

class Exit extends BaseCommand {
    public Exit(String input) {
        super(input);
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
