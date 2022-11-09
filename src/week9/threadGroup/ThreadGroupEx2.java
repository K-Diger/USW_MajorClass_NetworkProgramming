package week9.threadGroup;

import week9.runnable.CountDown;

public class ThreadGroupEx2 {

    public static void main(String[] args) {
        ThreadGroup timer = new ThreadGroup("Timer");

        // new ThreadGroup(parents, groupName);
        ThreadGroup suwon = new ThreadGroup(timer, "Suwon Timer");
        ThreadGroup jeju = new ThreadGroup(timer, "Jeju Timer");

        suwon.setMaxPriority(1);
        jeju.setMaxPriority(10);

        Thread suwonCountDown = new Thread(suwon, new CountDown(), "Suwon CountDown");
        Thread jejuCountDown = new Thread(jeju, new CountDown(), "Jeju CountDown");

        suwonCountDown.start();
        // Thread Join 추가로, jejuCountDown은 SuwonCountDown 이 끝나야지 사용가능하다.
        // 근데, 기다리고 있는 대상의 자리를 급하게 뺏어야한다면 인터럽트 발생가능
        try {
            suwonCountDown.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        jejuCountDown.start();
    }
}
