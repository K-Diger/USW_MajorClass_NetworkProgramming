package week9.threadbasic;

import week9.runnable.CountDown;

public class ThreadEx1 extends Thread {

    String name;

    public ThreadEx1(CountDown countDown, String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 10; i > -1; i--) {
            System.out.println(name + " : " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}