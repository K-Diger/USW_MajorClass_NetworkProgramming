package week9.demon;

public class DemonEx1 {

    public static void main(String[] args) throws InterruptedException {
        Thread notificationThread = new Thread(new Notification(), "Notification Thread");

        // 데몬 쓰레드로 셋팅하는 구문 시작 (메인 쓰레드에서 파생되었다.)
        notificationThread.setDaemon(true);
        // 데몬 쓰레드로 셋팅하는 구문 종료

        notificationThread.start();

        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());

        // 메인 쓰레드 재우기
        Thread.sleep(10 * 1000);
        
        System.out.println("Server Thread has been ended!!!");
    }
}
