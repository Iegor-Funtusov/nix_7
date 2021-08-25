package ua.com.alevel;

import ua.com.alevel.data.User;
import ua.com.alevel.func.PrintConsole;
import ua.com.alevel.func.PrintConsoleImpl;
import ua.com.alevel.func.Sum;
import ua.com.alevel.set.SetTest;

import java.util.ArrayList;
import java.util.List;

public class CollectionStartMain {

    public static void main(String[] args) {
//        ListTest listTest = new ListTest();
//        listTest.banch();
//        for (int i = 0; i < 100; i++) {
//        }
//        SetTest setTest = new SetTest();
//        setTest.banch();
//        PrintConsole printConsole = new PrintConsoleImpl();
//
//        printConsole = new PrintConsole() {
//            @Override
//            public void print(String s) {
//                System.out.println("s = " + s);
//            }
//        };
//        printConsole.print("hello world");

//        printConsole = (s) -> System.out.println("s = " + s);
//        printConsole.print("hello world");
//
        Sum sum = new Sum() {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };
//
//        sum = (a, b) -> {
//            System.out.println("a = " + a);
//            return a + b;
//        };
//
        sum = (a, b) -> a + b;
        sum = Integer::sum;
//        System.out.println(sum.sum(2, 9));

        new Refer().test();
    }
}
