package com.cprieto.tcmt.agent;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MonotouchCommandLine {
    private final String monotouchCommand = "Contents/MacOS/mdtool";
    private final MonotouchParameters parameters;

    public MonotouchCommandLine(@NotNull MonotouchParameters parameters) {
        this.parameters = parameters;
    }

    public String getCommandLine() {
        File baseDirectory = new File(parameters.getMonotoolsPath());
        File execFile = new File(baseDirectory, monotouchCommand);

        String execPath = execFile.getPath();

        return execPath;
    }

    @NotNull
    public List<String> getArgs() {
        List<String> args = new ArrayList<String>();
        args.add("build");

        args.add(escapeIfNeeded(parameters.getSolutionPath()));

        return args;
    }

    private String escapeIfNeeded(String input) {
        if (input.contains(" "))
            return String.format("\"%s\"", input);
        return input;
    }
}
