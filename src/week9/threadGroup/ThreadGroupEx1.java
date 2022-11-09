package week9.threadGroup;

public class ThreadGroupEx1 {

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println("thread.getName() = " + thread.getName());
        System.out.println("thread.getThreadGroup().getName() = " + thread.getThreadGroup().getName());
        System.out.println("thread.getThreadGroup().getParent() = " + thread.getThreadGroup().getParent());
        System.out.println("thread.getThreadGroup().getMaxPriority() = " + thread.getThreadGroup().getMaxPriority());

        thread.getThreadGroup().list();
    }
}
