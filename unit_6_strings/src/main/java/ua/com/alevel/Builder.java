package ua.com.alevel;

public class Builder {

    private static int SIZE = 10_000;

    public void test() {
        String s = "";
        long start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            s += i;
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("end = " + end);

        StringBuilder stringBuilder = new StringBuilder("");
        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            stringBuilder.append(i);
        }
        end = System.currentTimeMillis() - start;
        System.out.println("end = " + end);
    }

    public void methods() {
        StringBuilder builder = new StringBuilder("12345");
        StringBuffer buffer = new StringBuffer();
        builder.reverse();
        System.out.println("builder = " + builder);

        String s1 = "s1";
        String s2 = "s1";

        boolean compare = s1.equals(s2);
        System.out.println("compare = " + compare);


    }
}
