package org.javuntu.shell;

import org.javuntu.shell.services.CommandContext;
import org.javuntu.shell.services.CommandLoader;
import org.javuntu.shell.services.CommandRegistry;

import java.util.List;

public class ShellEngine {
    private final CommandRegistry commandRegistry;
    private final CommandContext context;

    public ShellEngine() {
        List<Command> commands = CommandLoader.loadCommands(ShellConstants.PATH);
        commandRegistry = new CommandRegistry(commands.toArray(new Command[0]));

        context = new CommandContext();
    }



}
