package ua.com.alevel.map;

import ua.com.alevel.data.User;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {

    private static final int SIZE = 4_000_000;

    public void run() {
        long start;
        long end;

//        Map<Integer, Integer> map = new HashMap<>();
//        start = System.currentTimeMillis();
//        for (int i = 0; i < SIZE; i++) {
//            map.put(i, i);
//        }
//        end = System.currentTimeMillis() - start;
//        System.out.println("end HashMap = " + end);

//        map.forEach((k, v) -> {
//            System.out.println("k = " + k);
//            System.out.println("v = " + v);
//        });

//        System.out.println();
//
//        map = new LinkedHashMap<>();
//        start = System.currentTimeMillis();
//        for (int i = 0; i < SIZE; i++) {
//            map.put(i, i);
//        }
//        end = System.currentTimeMillis() - start;
//        System.out.println("end LinkedHashMap = " + end);
//
//        System.out.println();

        Map<User, Integer> map1 = new TreeMap<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            map1.put(new User(i, "1"), i);
        }
        end = System.currentTimeMillis() - start;
        System.out.println("end TreeMap = " + end);
    }
}
