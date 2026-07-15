package org.javuntu.shell.services;

public record CommandResult(String output) {
    public static CommandResult text(String output) {
        return new CommandResult(output);
    }

    public static CommandResult empty() {
        return new CommandResult("");
    }
}