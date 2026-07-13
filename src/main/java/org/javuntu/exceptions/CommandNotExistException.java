package org.javuntu.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class CommandNotExistException extends RuntimeException {
    public CommandNotExistException(String commandName) {
        super(String.format("Unknown command: %s", commandName));
    }
}
