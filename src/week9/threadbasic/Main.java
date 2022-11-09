package week9.threadbasic;

import week9.runnable.CountDown;

public class Main {
    public static void main(String[] args) {
        ThreadEx1 a1 = new ThreadEx1(new CountDown(), "A1");
        ThreadEx1 b1 = new ThreadEx1(new CountDown(), "B1");
        ThreadEx1 c1 = new ThreadEx1(new CountDown(), "C1");

        a1.start();
        b1.start();
        c1.start();


        // countDown("A1");
        // countDown("B1");
        // countDown("C1");
    }

    public static void countDown(String name) {
        for (int i = 10; i > -1; i--) {
            System.out.println(name + ": " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
