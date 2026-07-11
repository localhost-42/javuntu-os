package org.javuntu.shell;

import org.javuntu.shell.services.CommandContext;
import org.javuntu.shell.services.CommandResult;

import java.util.List;

/**
 * Represents a command that can be executed by the Javuntu shell.
 * Each command has a name, a short description, usage text, and execution logic.
 *
 * The shell uses the command name to find the correct command,
 * the description and usage are shown in help messages,
 * and the execute method contains the actual behavior of the command.
 *
 * The execute method receives the current shell context and the arguments typed
 * by the user. The context gives the command access to shell state, such as the
 * current directory, while the args list contains everything written after the
 * command name. The method returns a CommandResult, which tells the shell what
 * text or action should be shown after the command finishes.
 */
public interface Command {
    String name();

    String description();

    String usage();

    CommandResult execute(CommandContext context, List<String> args);
}
