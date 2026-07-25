package org.javuntu.shell.services;

import java.util.ArrayList;
import java.util.List;

public class CommandParser {

    public static List<String> parse(String line) {
        List<String> tokens = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        boolean isInsideSingleQuotes = false;
        boolean isInsideDoubleQuotes = false;

        for (int charIndex = 0; charIndex < line.length(); charIndex++) {
            char ch = line.charAt(charIndex);

            if (ch == '\'' && !isInsideDoubleQuotes) {
                isInsideSingleQuotes = !isInsideSingleQuotes;
            } else if (ch == '"' && !isInsideSingleQuotes) {
                isInsideDoubleQuotes = !isInsideDoubleQuotes;
            } else if (Character.isWhitespace(ch) && !isInsideSingleQuotes && !isInsideDoubleQuotes) {
                addTokenIfNeeded(tokens, current);
            } else {
                current.append(ch);
            }
        }

        addTokenIfNeeded(tokens, current);
        return tokens;
    }

    private static void addTokenIfNeeded(List<String> tokens, StringBuilder word) {
        if (!word.isEmpty()) {
            tokens.add(word.toString());
            word.setLength(0);
        }
    }
}
