package org.javuntu.shell;

import org.javuntu.exceptions.CommandNotExistException;
import org.javuntu.shell.services.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ShellEngine {
    private final CommandRegistry registry;
    private final CommandContext context;

    public ShellEngine() {
        List<Command> commands = CommandLoader.loadCommands(ShellConstants.PATH);
        registry = new CommandRegistry(commands.toArray(new Command[0]));

        context = new CommandContext();
    }

    public CommandResult execute(String line) {
        List<String> tokens = CommandParser.parse(line);

        if (tokens.isEmpty()) {
            return CommandResult.empty();
        }

        String commandName = tokens.get(0);
        List<String> args = new ArrayList<>(tokens.subList(1, tokens.size()));

        Command command = registry.getCommand(commandName);

        if (command != null) {
            return command.execute(context, String.valueOf(args));
        }

        return runExternalCommand(tokens);
    }

    private CommandResult runExternalCommand(List<String> tokens) {
        final int EXIT_CODE_OK = 0;

        ProcessBuilder processBuilder = new ProcessBuilder(tokens);
        processBuilder.directory(context.getCurrentDirectory());
        processBuilder.redirectErrorStream(true);

        try {
            Process process = processBuilder.start();
            StringBuilder output = new StringBuilder();

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8))) {

                String line = reader.readLine();

                while (line != null) {
                    output.append(line).append(System.lineSeparator());
                    line = reader.readLine();
                }
            }

            boolean finished = process.waitFor(10, TimeUnit.SECONDS);
            if (!finished) {
                process.destroyForcibly();
                return CommandResult.text("Command timed out after 10 seconds.");
            }

            int exitCode = process.exitValue();
            if (exitCode != EXIT_CODE_OK && output.isEmpty()) {
                output.append("Process exited with code ").append(exitCode);
            }

            return CommandResult.text(output.toString());
        } catch (IOException error) {
            return CommandResult.text("Unknown command: " + tokens.get(0));
        } catch (InterruptedException error) {
            Thread.currentThread().interrupt();

            return CommandResult.text("Command interrupted.");
        }
    }
}
