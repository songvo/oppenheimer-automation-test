package com.oppenheimer.bdd;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.testng.collections.Maps;

import java.util.Map;

@Component
@Scope("cucumber-glue")
public class ScenarioContext {
    private final Map<String, Object> contextValuesMap = Maps.newHashMap();

    public <T> void put(final Context key, final T value) {
        contextValuesMap.put(key.toString(), value);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(final Context key) {
        final Object value = contextValuesMap.get(key.toString());
        return (T) value;
    }

    public void remove(final Context key) {
        contextValuesMap.remove(key.toString());
    }
}
