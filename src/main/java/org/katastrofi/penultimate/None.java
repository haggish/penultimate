package org.katastrofi.penultimate;

class None extends BaseCommand {

    None(String input) {
        super(input);
    }

    @Override
    public void execute() {
        System.out.println(String.format("Nonesuch command %s", input()));
    }
}
