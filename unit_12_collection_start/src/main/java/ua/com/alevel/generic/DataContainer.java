package ua.com.alevel.generic;

public class DataContainer<DATA extends Comparable<DATA>> {

    private ResponseContainer<DATA> data;

    public ResponseContainer<DATA> getData() {
        return data;
    }

    public void setData(ResponseContainer<DATA> data) {
        this.data = data;
    }
}
