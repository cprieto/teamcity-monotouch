package com.cprieto.tcmt.agent;

import com.cprieto.tcmt.PluginConstants;
import jetbrains.buildServer.RunBuildException;
import jetbrains.buildServer.agent.AgentBuildRunnerInfo;
import jetbrains.buildServer.agent.AgentRunningBuild;
import jetbrains.buildServer.agent.BuildAgentConfiguration;
import jetbrains.buildServer.agent.runner.CommandLineBuildService;
import jetbrains.buildServer.agent.runner.CommandLineBuildServiceFactory;
import jetbrains.buildServer.agent.runner.ProgramCommandLine;
import jetbrains.buildServer.log.Loggers;
import org.jetbrains.annotations.NotNull;

public class MonotouchBuildServiceFactory implements CommandLineBuildServiceFactory {
    private AgentRunningBuild agentRunningBuild;

    public MonotouchBuildServiceFactory() {
    }

    @NotNull
    @Override
    public CommandLineBuildService createService() {
        return new MonotouchBuildServiceAdapter();
    }

    @NotNull
    @Override
    public AgentBuildRunnerInfo getBuildRunnerInfo() {
        return new AgentBuildRunnerInfo() {
            @NotNull
            @Override
            public String getType() {
                return PluginConstants.RUNNER_TYPE;
            }

            @Override
            public boolean canRun(@NotNull BuildAgentConfiguration buildAgentConfiguration) {
                return buildAgentConfiguration.getSystemInfo().isMac();
            }
        };
    }
}
