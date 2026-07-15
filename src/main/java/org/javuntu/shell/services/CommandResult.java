package org.javuntu.shell.services;

public record CommandResult(String output, boolean shouldClearScreen, boolean shouldExit) {
    public static CommandResult text(String output) {
        return new CommandResult(output, false, false);
    }

    public static CommandResult empty() {
        return new CommandResult("", false, false);
    }

    public static CommandResult clearScreen() {
        return new CommandResult("", true, false);
    }

    public static CommandResult exit() {
        return new CommandResult("", false, true);
    }
}