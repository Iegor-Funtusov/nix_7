package org.diframework.configure.configurator.impl;

import org.apache.commons.lang3.StringUtils;
import org.diframework.ApplicationContext;
import org.diframework.annotation.ResourceProperty;
import org.diframework.configure.configurator.ObjectConfigurator;
import org.diframework.util.ResourceUtil;

import java.lang.reflect.Field;
import java.util.Map;

public class ResourcePropertyObjectConfigurator implements ObjectConfigurator {

    @Override
    public void configure(Object o, ApplicationContext context) {
        Field[] declaredFields = o.getClass().getDeclaredFields();
        Map<String, String> map = ResourceUtil.getResource(context.getMainClassLoader());
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(ResourceProperty.class)) {
                ResourceProperty resourceProperty = declaredField.getAnnotation(ResourceProperty.class);
                String value = resourceProperty.value();
                String props = map.get(value);
                if (StringUtils.isNotBlank(props)) {
                    declaredField.setAccessible(true);
                    try {
                        declaredField.set(o, props);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("problem from initial field");
                    }
                }
            }
        }
    }
}
