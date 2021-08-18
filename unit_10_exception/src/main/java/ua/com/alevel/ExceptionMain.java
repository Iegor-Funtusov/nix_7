package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionMain {

    public static void main(String[] args) {

        ThreadTest threadTest = new ThreadTest();
        threadTest.test();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer d = null;
        Integer deltaRes = null;

        try {
            d = Integer.parseInt(bufferedReader.readLine());
            deltaRes = RuntimeTest.calculateDelta(d);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            throw new RuntimeException("user is stupid");
        }
//        System.out.println("deltaRes = " + deltaRes);


//        ExceptionUpTest exceptionUpTest = new ExceptionUpTest();
//        TryTest tryTest = new TryTest();
//        tryTest.test2();
//        try {
//            System.exit(1);
//            exceptionUpTest.testNull(null);
//            exceptionUpTest.testZero(0);
//        }
//        catch (ArithmeticException | NullPointerException e) {
//            if (e instanceof ArithmeticException) {
//                System.out.println("ArithmeticException = " + e.getMessage());
//            }
//            if (e instanceof NullPointerException) {
//                System.out.println("NullPointerException = " + e.getMessage());
//            }
//        }
//        catch (ArithmeticException e) {
//            System.out.println("ArithmeticException = " + e.getMessage());
//        }
//        catch (NullPointerException e) {
//            System.out.println("NullPointerException = " + e.getMessage());
//        }
//        finally {
//            System.out.println("finally !!!!!!!!!!!!!!!!");
//        }

//        Throwable throwable;
//
//        Error error;
//        OutOfMemoryError outOfMemoryError;
//        StackOverflowError stackOverflowError;
//
//        Exception exception;
//        RuntimeException runtimeException;
//        IOException ioException;
//        SQLException sqlException;

        // java -Xmx=1024m -Xms=10G -Xss=1G -jar <jar_name>
    }
}
