package com.cprieto.tcmt.agent;

import jetbrains.buildServer.RunBuildException;
import jetbrains.buildServer.agent.runner.BuildServiceAdapter;
import jetbrains.buildServer.agent.runner.ProgramCommandLine;
import org.jetbrains.annotations.NotNull;

public class MonotouchBuildServiceAdapter extends BuildServiceAdapter {
    @NotNull
    @Override
    public ProgramCommandLine makeProgramCommandLine() throws RunBuildException {
        MonotouchCommandLine cmd = new MonotouchCommandLine(null);

        return createProgramCommandline(cmd.getCommandLine(), cmd.getArgs());
    }
}
