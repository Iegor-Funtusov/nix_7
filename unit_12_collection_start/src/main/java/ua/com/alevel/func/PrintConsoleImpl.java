package ua.com.alevel.func;

public class PrintConsoleImpl implements PrintConsole {

    @Override
    public void print(String s) {
        System.out.println("s = " + s);
    }
}
