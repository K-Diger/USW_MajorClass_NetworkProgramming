package week9.runnable;

/*

Thread() 는 생성자로 Runnable 객체를 받을 수 있다.

 */
public class Main {
    public static void main(String[] args) {
        Thread a1 = new Thread(new CountDown(), "A1");
        Thread b1 = new Thread(new CountDown(), "B1");
        Thread c1 = new Thread(new CountDown(), "C1");

        a1.start();
        b1.start();
        c1.start();
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
