package com.example.geektrust.model;

import com.example.geektrust.exception.InValidCommandException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Command : model object to represent input command
 */

public class Command {
    private static final String SPACE = " ";
    private final String commandName;

    private final List<String> params;

    /**
     * Constructor : It takes String inputLine as parameter and extracts commandName and params from it. If inputLine is empty string then it will throw {@link InValidCommandException}
     * @param inputLine Given input from command line
     */

    public Command(final String inputLine){

        final List<String> inputs = Arrays.stream(inputLine.trim().split(SPACE))    // removing white space from input string
                .map(String :: trim)
                .filter(input -> input.length() > 0)    // filtering only valid string
                .collect(Collectors.toList());

        // empty string
        if (inputs.isEmpty())
            throw new InValidCommandException();


        commandName = inputs.get(0).toUpperCase();  // first argument is always command name
        inputs.remove(0);
        params = inputs; // remaining are parameter or arguments necessary to execute command

    }

    public String getCommandName() {
        return commandName;
    }

    public List<String> getParams() {
        return params;
    }
}
