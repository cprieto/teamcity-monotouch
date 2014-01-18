package com.cprieto.tcmt.server;

import com.cprieto.tcmt.PropertyNames;
import jetbrains.buildServer.serverSide.InvalidProperty;
import jetbrains.buildServer.serverSide.PropertiesProcessor;

import java.util.Collection;
import java.util.Map;
import java.util.Vector;

public class MonotouchPropertiesProcessor implements PropertiesProcessor {
    @Override
    public Collection<InvalidProperty> process(Map<String, String> stringStringMap) {
        Vector<InvalidProperty> invalidProperties = new Vector<InvalidProperty>();
        if (isEmpty(stringStringMap, PropertyNames.SOLUTION_NAME))
            invalidProperties.add(new InvalidProperty(PropertyNames.SOLUTION_NAME,
                    "You need to specify the name of the solution file"));

        if (isEmpty(stringStringMap, PropertyNames.MONOTOUCH_PATH))
            invalidProperties.add(new InvalidProperty(PropertyNames.MONOTOUCH_PATH,
                    "Without Xamarin Studio you cannot compile Monotouch projects"));

        return invalidProperties;
    }

    private boolean isEmpty(Map<String, String> properties, String key){
        return properties.containsKey(key) == false
            || properties.get(key).isEmpty();
    }
}
