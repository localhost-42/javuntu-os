package org.javuntu.shell.services;

import org.javuntu.shell.Command;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.*;

/**
 * Command loader load commands from given paths to the registry
 *
 *
 *
 */

public class CommandLoader {
    public static List<Command> loadCommands(String... packageNames) {
        validatePackageNames(packageNames);

        Set<Class<? extends Command>> commandClasses = discoverCommandClasses(packageNames);

        return commandClasses.stream()
                .filter(CommandLoader::isConstructable)
                .map(CommandLoader::createCommand)
                .sorted(Comparator.comparing(Command::name))
                .toList();
    }

    // Validate the package names - check if empty or null
    private static void validatePackageNames(String[] packageNames) {
        if (packageNames == null || packageNames.length == 0) {
            throw new IllegalArgumentException(
                    "At least one command package is required."
            );
        }

        for (String packageName : packageNames) {
            if (packageName == null || packageName.isBlank()) {
                throw new IllegalArgumentException(
                        "Command package name cannot be blank."
                );
            }
        }
    }

    private static Set<Class<? extends Command>> discoverCommandClasses(String[] packageNames) {
        Set<Class<? extends Command>> commandClasses = new LinkedHashSet<>();

        for (String packageName : packageNames) {
            Reflections reflections = new Reflections(packageName);

            commandClasses.addAll(
                    reflections.getSubTypesOf(Command.class)
            );
        }

        return commandClasses;
    }

    private static boolean isConstructable(Class<? extends Command> commandClass) {
        // get information about the class - is public, private, class, interface, abstract, finale
        int modifiers = commandClass.getModifiers();

        // The class is constructable if it is not interface or abstract
        return !Modifier.isInterface(modifiers) && !Modifier.isAbstract(modifiers);
    }

    private static Command createCommand(Class<? extends Command> commandClass) {
        try {
            return commandClass
                    .getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException exception) {
            throw new IllegalStateException("Failed to create command: " + commandClass.getName(), exception);
        }
    }
}
