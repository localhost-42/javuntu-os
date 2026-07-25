package org.javuntu.shell.ui;

import org.javuntu.metadata.AppMetadata;
import org.javuntu.shell.ShellConstants;
import org.javuntu.shell.ShellEngine;
import org.javuntu.shell.services.CommandResult;
import org.javuntu.system.SystemActions;

import java.util.Scanner;

public class ConsoleShell implements ShellUI {
    private final ShellEngine shellEngine;

    public ConsoleShell(ShellEngine shellEngine) {
        this.shellEngine = shellEngine;
    }

    @Override
    public void build() {
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(AppMetadata.NAME + " Shell " + AppMetadata.VERSION);
        System.out.println("Type 'help' to see commands.");

        while (true) {
            System.out.print(ShellConstants.PROMPT);

            if (!scanner.hasNextLine()) {
                break;
            }

            String line = scanner.nextLine();
            CommandResult result = shellEngine.execute(line);

            if (!result.output().isBlank()) {
                System.out.print(result.output());

                if (!result.output().endsWith("\n")) {
                    System.out.println();
                }
            }

            if (result.shouldExit()) {
                SystemActions.exitApplication();
            }
        }
    }
}
