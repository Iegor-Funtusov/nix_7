package org.diframework.configure.invoker;

public interface ObjectInvoker {

    <I> void invoke(Class<I> type, I i);
}
