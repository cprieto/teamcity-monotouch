package com.cprieto.tcmt.server;

import jetbrains.buildServer.serverSide.InvalidProperty;
import jetbrains.buildServer.serverSide.PropertiesProcessor;

import java.util.Collection;
import java.util.Map;
import java.util.Vector;

public class MonotouchPropertiesProcessor implements PropertiesProcessor {
    @Override
    public Collection<InvalidProperty> process(Map<String, String> stringStringMap) {
        Vector<InvalidProperty> invalidProperties = new Vector<InvalidProperty>();
        return invalidProperties;
    }
}
