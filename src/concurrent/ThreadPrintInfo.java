package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPrintInfo extends Thread {
    private TimerObject timeFromStart;
    private String threadName;
    private int printTime;
    private Lock locker;
    private Condition condition;

    public ThreadPrintInfo(String threadName, int printTime, TimerObject timeFromStart, ReentrantLock locker, Condition condition) {
        this.threadName = threadName;
        this.printTime = printTime;
        this.timeFromStart = timeFromStart;
        this.locker = locker;
        this.condition = condition;
    }

    @Override
    public void run() {
        while (true) {
            locker.lock();
            try {
                while (timeFromStart.getTimeFromStart() % printTime != 0)
                    condition.await();
                System.out.println(threadName);
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                locker.unlock();
            }

        }
    }
}
