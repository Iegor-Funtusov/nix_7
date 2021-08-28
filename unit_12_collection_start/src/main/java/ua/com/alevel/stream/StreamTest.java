package ua.com.alevel.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    public void run() {
        Stream<String> stream1 = "fsafdasfas".lines();
        Stream<char[]> stream2 = Arrays.asList("fsafdasfas".toCharArray()).stream();
        Stream<char[]> stream3 = Stream.of("fsafdasfas".toCharArray());
        Stream<String> stream4 = List.of("1", "2", "3").stream();

        char[] myCharArray = "fsafdasfas".toCharArray();

        List<String> list = Arrays.asList("a", "s", "a", "i", "p", "p", "f");

        List<String> strings = list
                .stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("strings = " + strings);

        strings = list
                .stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("strings = " + strings);

        strings = list
                .stream()
                .skip(4)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("strings = " + strings);

        strings = list
                .stream()
                .distinct()
                .filter(s -> !s.equals("a"))
                .sorted()
                .collect(Collectors.toList());
        System.out.println("strings = " + strings);

        List<String> listInteger = Arrays.asList("0", "5", "9", "5", "8", "0", "11");
        List<Integer> integers = listInteger
                .stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        System.out.println("integers = " + integers);

        listInteger = Arrays.asList("0", "5", "9", "5", "8", "0", "11");
        integers = listInteger
                .stream()
                .map(Integer::parseInt)
                .distinct()
                .filter(integer -> integer % 2 == 0)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("integers = " + integers);

        listInteger = Arrays.asList("0", "5", "9", "5", "8", "0", "10", "2", "1a");
        int sum = listInteger
                .stream()
                .filter(s -> s.matches("\\d+"))
                .map(Integer::parseInt)
                .distinct()
                .filter(integer -> integer % 2 == 0)
                .reduce(Integer::sum)
                .get();
        System.out.println("sum = " + sum);

        boolean contains = listInteger.stream().noneMatch(s -> s.equals("22"));
        System.out.println("contains = " + contains);
    }

    public void banch() {
        long start;
        long end;
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 200_000_000; i++) {
            integers.add(i);
        }
        int sum = 0;
        start = System.currentTimeMillis();
        for (Integer integer : integers) {
            sum += integer;
        }
        end = System.currentTimeMillis() - start;
        System.out.println("sum = " + sum);
        System.out.println("end = " + end);

        start = System.currentTimeMillis();
        int sum1 = integers
                .stream()
                .reduce(Integer::sum)
                .get();
        end = System.currentTimeMillis() - start;
        System.out.println("sum = " + sum1);
        System.out.println("end = " + end);

        start = System.currentTimeMillis();
        int sum2 = integers
                .stream()
                .parallel()
                .reduce(Integer::sum)
                .get();
        end = System.currentTimeMillis() - start;
        System.out.println("sum2 = " + sum2);
        System.out.println("end = " + end);

        start = System.currentTimeMillis();
        int sum3 = integers
                .parallelStream()
                .reduce(Integer::sum)
                .get();
        end = System.currentTimeMillis() - start;
        System.out.println("sum3 = " + sum3);
        System.out.println("end = " + end);
    }
}
