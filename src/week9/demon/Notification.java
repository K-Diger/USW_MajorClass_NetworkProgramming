package week9.demon;

// 단축키 Ctrl + Alt + T !!! if, for, while 등 드래그한 내용에 코드블럭구문 추가 가능

public class Notification implements Runnable {

    @Override
    public void run() {
        while (true) {
            int message = (int) (Math.random() * 10) + 1;
            try {
                System.out.println("message = " + message);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
