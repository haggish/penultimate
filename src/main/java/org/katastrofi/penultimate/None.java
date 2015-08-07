package org.katastrofi.penultimate;

import static java.lang.String.format;

class None extends BaseCommand {
    None(String input) {
        super(input);
    }

    public String toString() {
        return format("Nonesuch command %s", input());
    }
}
