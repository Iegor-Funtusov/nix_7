package ua.com.alevel.unit_api_web.container;

public class DataContainer<T> {

    private T data;

    public DataContainer(T t) {
        data = t;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
