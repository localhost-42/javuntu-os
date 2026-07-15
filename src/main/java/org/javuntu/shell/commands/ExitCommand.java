package org.javuntu.shell.commands;

import org.javuntu.shell.Command;
import org.javuntu.shell.services.CommandContext;
import org.javuntu.shell.services.CommandResult;

import java.util.List;

public class ExitCommand implements Command {
    @Override
    public String name() {
        return "exit";
    }

    @Override
    public String description() {
        return "Exit the current shell session";
    }

    @Override
    public String usage() {
        return "exit";
    }

    @Override
    public CommandResult execute(CommandContext context, List<String> args) {
        return CommandResult.exit();
    }
}