package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock locker = new ReentrantLock();
        Condition condition = locker.newCondition();
        TimerObject timerMonitor = new TimerObject(locker, condition);
        ThreadTimer timer = new ThreadTimer(timerMonitor, locker, condition);
        timer.start();
        List<ThreadPrintInfo> infoTreads = new ArrayList<>();
        infoTreads.add(new ThreadPrintInfo("Thread 5", 5, timerMonitor, locker, condition));
        infoTreads.add(new ThreadPrintInfo("Thread 7", 7, timerMonitor, locker, condition));
        for (ThreadPrintInfo printInfo : infoTreads) {
            printInfo.start();
        }
    }
}
