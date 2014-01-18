package com.cprieto.tcmt.server;

import com.cprieto.tcmt.PluginConstants;
import com.cprieto.tcmt.PropertyNames;
import jetbrains.buildServer.serverSide.PropertiesProcessor;
import jetbrains.buildServer.serverSide.RunType;
import jetbrains.buildServer.serverSide.RunTypeRegistry;

import java.util.HashMap;
import java.util.Map;

public class MonotouchRunType extends RunType {
    public MonotouchRunType(final RunTypeRegistry runTypeRegistry) {
        runTypeRegistry.registerRunType(this);
    }

    @Override
    public String getType() {
        return PluginConstants.RUNNER_TYPE;
    }

    @Override
    public String getDisplayName() {
        return PluginConstants.RUNNER_NAME;
    }

    @Override
    public String getDescription() {
        return PluginConstants.RUNNER_DESCRIPTION;
    }

    @Override
    public PropertiesProcessor getRunnerPropertiesProcessor() {
        return new MonotouchPropertiesProcessor();
    }

    @Override
    public String getEditRunnerParamsJspFilePath() {
        return null;
    }

    @Override
    public String getViewRunnerParamsJspFilePath() {
        return null;
    }

    @Override
    public Map<String, String> getDefaultRunnerProperties() {
        Map<String, String> properties = new HashMap<String, String>();
        properties.put(PropertyNames.MONOTOUCH_PATH, "/Applications/Xamarin Studio.app/Contents/MacOS/mdtool");

        return properties;
    }
}
