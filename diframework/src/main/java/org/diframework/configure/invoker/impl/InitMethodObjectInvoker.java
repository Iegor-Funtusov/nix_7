package org.diframework.configure.invoker.impl;

import org.diframework.annotation.InitMethod;
import org.diframework.configure.invoker.ObjectInvoker;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InitMethodObjectInvoker implements ObjectInvoker {

    @Override
    public <I> void invoke(Class<I> type, I i) {
        for (Method method : type.getDeclaredMethods()) {
            if (method.isAnnotationPresent(InitMethod.class)) {
                method.setAccessible(true);
                try {
                    method.invoke(i);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
