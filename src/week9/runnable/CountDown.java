package week9.runnable;

public class CountDown implements Runnable{

    @Override
    public void run() {
        for (int i = 10; i > -1; i--) {
             Thread currentThread = Thread.currentThread();
//            Thread.currentThread().getName();
            System.out.println("currentThread.getName() = " + currentThread.getName());
            System.out.println("currentThread.getThreadGroup() = " + currentThread.getThreadGroup());
            System.out.println("i = " + i);
            System.out.println();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
