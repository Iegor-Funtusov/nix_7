package ua.com.alevel.generic;

public class ResponseContainer<DATA> extends ExceptionContainer {

    private DATA res;

    public DATA getRes() {
        return res;
    }

    public void setRes(DATA res) {
        this.res = res;
    }
}
