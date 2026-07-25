package org.javuntu.shell.services;

import lombok.Getter;
import lombok.Setter;
import org.javuntu.shell.ShellConstants;
import org.javuntu.system.SystemConstants;
import org.javuntu.system.SystemProperties;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CommandContext {

    @Getter
    @Setter
    private File currentDirectory;

    private final Map<String, String> variables;

    public CommandContext() {
        this.currentDirectory = new File(SystemProperties.getProperty(SystemConstants.USER_HOME_KEY));
        this.variables = new HashMap<>();

        initEnvironmentVariables();
    }

    private void initEnvironmentVariables() {
        final String DEFAULT_USERNAME = "user";

        variables.put(ShellConstants.SHELL_NAME_VARIABLE, ShellConstants.SHELL_NAME);

        variables.put(ShellConstants.USER_NAME_VARIABLE,
                SystemProperties.getProperty(SystemConstants.USER_NAME_KEY, DEFAULT_USERNAME));
    }

    public Map<String, String> getVariablesList() {
        return Collections.unmodifiableMap(variables);
    }

    public void setVariable(String key, String value) {
        variables.put(key, value);
    }

    public String getVariable(String key) {
        return variables.get(key);
    }
}
