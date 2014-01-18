package com.cprieto.tcmt.agent;

import com.cprieto.tcmt.PropertyNames;
import com.intellij.util.xmlb.annotations.Property;

import java.util.Map;

public class MonotouchParameters {
    private String monotoolsPath;
    private String solutionPath;
    private String configuration;

    private MonotouchParameters() {
    }

    public String getMonotoolsPath() {
        return monotoolsPath;
    }

    public String getSolutionPath() {
        return solutionPath;
    }

    public String getConfiguration() {
        return configuration;
    }

    private void setMonotoolsPath(String monotoolsPath) {
        this.monotoolsPath = monotoolsPath;
    }

    private void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    private void setSolutionPath(String solutionPath) {
        this.solutionPath = solutionPath;
    }

    public static MonotouchParameters Parse(Map<String, String> parameters) {
        MonotouchParameters parsedParameters = new MonotouchParameters();

        parsedParameters.setConfiguration(parameters.get(PropertyNames.CONFIGURATION));
        parsedParameters.setMonotoolsPath(parameters.get(PropertyNames.MONOTOUCH_PATH));
        parsedParameters.setSolutionPath(parameters.get(PropertyNames.SOLUTION_NAME));

        return parsedParameters;
    }
}
