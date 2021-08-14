package org.diframework.configure.configurator.impl;

import org.diframework.ApplicationContext;
import org.diframework.annotation.InjectBean;
import org.diframework.configure.configurator.ObjectConfigurator;

import java.lang.reflect.Field;

public class InjectBeanObjectConfigurator implements ObjectConfigurator {

    @Override
    public void configure(Object o, ApplicationContext context) {
        Field[] declaredFields = o.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(InjectBean.class)) {
                declaredField.setAccessible(true);
                Object impl = context.getObjectImpl(declaredField.getType());
                try {
                    declaredField.set(o, impl);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("problem from initial field");
                }
            }
        }
    }
}
