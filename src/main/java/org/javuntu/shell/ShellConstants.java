package org.javuntu.shell;

public class ShellConstants {

    public static final String SHELL_NAME = "javuntu";
    public static final String PROMPT = String.format("%s> ", SHELL_NAME);
    public static final String SHELL_NAME_VARIABLE = "SHELL";
    public static final String USER_NAME_VARIABLE = "USER";

    public static final String[] PATH = {
        "org.javuntu.shell.commands"
    };

    private ShellConstants() {
    }
}
