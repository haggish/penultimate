package org.katastrofi.penultimate;

import java.util.Optional;

public interface Commanded {

    Optional<Result> handle(Command command);

}
