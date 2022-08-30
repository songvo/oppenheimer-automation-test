package com.oppenheimer.scopes;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;

import java.util.Objects;

public class ThreadScope extends SimpleThreadScope {
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object o = super.get(name, objectFactory);
        // When browser suddenly close
        SessionId sessionId = ((RemoteWebDriver)o).getSessionId();
        if(Objects.isNull(sessionId)) {
            super.remove(name);
            super.get(name, objectFactory);
        }
        return super.get(name, objectFactory);
    }
}
