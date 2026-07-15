package org.javuntu.shell.commands;

import org.javuntu.shell.Command;
import org.javuntu.shell.services.CommandContext;
import org.javuntu.shell.services.CommandResult;

import java.util.List;

public class ClearCommand implements Command {
    @Override
    public String name() {
        return "clear";
    }

    @Override
    public String description() {
        return "Clear the terminal screen";
    }

    @Override
    public String usage() {
        return "clear";
    }

    @Override
    public CommandResult execute(CommandContext context, List<String> args) {
        return CommandResult.clearScreen();
    }
}
