package org.katastrofi.penultimate;

interface Parser<I,O> {

    Command commandFrom(I input);

    O outputFrom(Result result);

}
