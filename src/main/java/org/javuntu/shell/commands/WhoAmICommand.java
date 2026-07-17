package org.javuntu.shell.commands;

import org.javuntu.shell.Command;
import org.javuntu.shell.services.CommandContext;
import org.javuntu.shell.services.CommandResult;
import org.javuntu.system.SystemConstants;
import org.javuntu.system.SystemProperties;

import java.util.List;

public class WhoAmICommand implements Command {
    @Override
    public String name() {
        return "whoami";
    }

    @Override
    public String description() {
        return "Show current user";
    }

    @Override
    public String usage() {
        return "whoami";
    }

    @Override
    public CommandResult execute(CommandContext context, String... args) {
        return CommandResult.text(
                SystemProperties.getProperty(SystemConstants.USER_NAME_KEY, "user")
        );
    }
}