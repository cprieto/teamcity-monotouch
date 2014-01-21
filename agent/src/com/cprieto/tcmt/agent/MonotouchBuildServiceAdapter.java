package com.cprieto.tcmt.agent;

import com.cprieto.tcmt.PropertyNames;
import jetbrains.buildServer.RunBuildException;
import jetbrains.buildServer.agent.runner.BuildServiceAdapter;
import jetbrains.buildServer.agent.runner.ProgramCommandLine;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import jetbrains.buildServer.log.Loggers;

import java.io.File;
import java.util.*;

public class MonotouchBuildServiceAdapter extends BuildServiceAdapter {
    private final String mdTool = "Contents/MacOS/mdtool";
    private final static Logger log = Logger.getLogger(MonotouchBuildServiceAdapter.class);

    private String getMdToolPath(final String xamarinPath) {
        File xamarinDir = new File(xamarinPath);
        File mdToolPath = new File(xamarinDir, mdTool);

        String path = mdToolPath.getAbsolutePath();
        return path;
    }

    @NotNull
    @Override
    public ProgramCommandLine makeProgramCommandLine() throws RunBuildException {
        final Map<String, String> options = getRunnerParameters();

        return new ProgramCommandLine() {
            @NotNull
            @Override
            public String getExecutablePath() throws RunBuildException {
                return getMdToolPath(options.get(PropertyNames.MONOTOUCH_PATH));
            }

            @NotNull
            @Override
            public String getWorkingDirectory() throws RunBuildException {
                return getCheckoutDirectory().getAbsolutePath();
            }

            @NotNull
            @Override
            public List<String> getArguments() throws RunBuildException {
                List<String> args = new ArrayList<String>();
                args.add("--verbose");
                args.add("build");
                args.add(options.get(PropertyNames.SOLUTION_NAME));

                return args;
            }

            @NotNull
            @Override
            public Map<String, String> getEnvironment() throws RunBuildException {
                return new HashMap<String, String>();
            }
        };
    }
}
