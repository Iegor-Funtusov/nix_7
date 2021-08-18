package ua.com.alevel;

public class ExceptionUpTest {

    public void testZero(int b) throws ArithmeticException {
        int a = 10 / b;
    }

    public void testNull(String s) {
        System.out.println("s = " + s.length());
    }
}
