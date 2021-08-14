package org.diframework.configure.configurator;

import org.diframework.ApplicationContext;

public interface ObjectConfigurator {

    void configure(Object o, ApplicationContext context);
}
