package com.cprieto.tcmt.agent;

import com.cprieto.tcmt.PluginConstants;
import jetbrains.buildServer.agent.AgentBuildRunnerInfo;
import jetbrains.buildServer.agent.BuildAgentConfiguration;

public class MonotouchRunnerInfo implements AgentBuildRunnerInfo {
    @Override
    public String getType() {
        return PluginConstants.RUNNER_TYPE;
    }

    @Override
    public boolean canRun(BuildAgentConfiguration buildAgentConfiguration) {
        return buildAgentConfiguration.getSystemInfo().isMac();
    }
}
