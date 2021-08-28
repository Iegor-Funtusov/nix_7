package ua.com.alevel;

import java.util.Collections;
import java.util.List;

public class SortTest<E extends Comparable<E>> {

    public void sort(List<E > collection) {
        Collections.sort(collection);
    }
}
