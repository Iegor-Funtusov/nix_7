package ua.com.alevel.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

    private static final int SIZE = 500_000;

    public void banch() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        long start = 0L;
        long end = 0L;

        // add

        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(i);
        }
        end = System.currentTimeMillis() - start;
        System.out.println("add: arrayList end = " + end);

        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            linkedList.add(i);
        }
        end = System.currentTimeMillis() - start;
        System.out.println("add: linkedList end = " + end);

        // remove

        Iterator<Integer> iterator = arrayList.iterator();
        start = System.currentTimeMillis();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        end = System.currentTimeMillis() - start;
        System.out.println("remove: arrayList end = " + end);

        iterator = linkedList.iterator();
        start = System.currentTimeMillis();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        end = System.currentTimeMillis() - start;
        System.out.println("remove: linkedList end = " + end);
    }
}
