package ua.com.alevel;

import com.google.gson.Gson;

import java.util.*;

public class TestJson {

    public void test() {
        Test[] tests = new Test[3];
        tests[0] = new Test(1, "1");
        tests[1] = new Test(2, "2");
        tests[2] = new Test(3, "3");

        Gson gson = new Gson();
        String json = gson.toJson(tests);
        System.out.println("json = " + json);

        List<List<Test>> list = new ArrayList<>();
        list.add(List.of(new Test(1, "1")));
        list.add(List.of(new Test(2, "2")));
        list.add(List.of(new Test(3, "3")));
        gson = new Gson();
        json = gson.toJson(list);
        System.out.println("json = " + json);

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        System.out.println("map = " + map);
        gson = new Gson();
        json = gson.toJson(map);
        System.out.println("json = " + json);

        map = gson.fromJson(json, Map.class);
        System.out.println("map = " + map);
    }
}
