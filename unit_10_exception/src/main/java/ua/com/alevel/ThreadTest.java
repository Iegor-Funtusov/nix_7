package ua.com.alevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadTest {

    public void test() {
        List<TestExecutor> testExecutors = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testExecutors.add(new TestExecutor());
        }
        for (int i = 0; i < 10; i++) {
            try {
                testExecutors.get(i).run();
            } catch (TestExecutorException e) {
                System.out.println("e = " + e.getMessage());
            }
        }
    }

    private static class TestExecutor implements Runnable {
        @Override
        public void run() {
            int r = new Random().nextInt(2);
            if (r == 1) {
                throw new TestExecutorException("Something problem");
            } else {
                System.out.println("problem is not exist");
            }
        }
    }
}
