package wait_notify;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TimerObject timerMonitor = new TimerObject();
        ThreadTimer timer = new ThreadTimer(timerMonitor);
        timer.start();
        List<ThreadPrintInfo> infoTreads = new ArrayList<>();
        infoTreads.add(new ThreadPrintInfo("Thread 5", 5, timerMonitor));
        infoTreads.add(new ThreadPrintInfo("Thread 7", 7, timerMonitor));
        for (ThreadPrintInfo printInfo : infoTreads) {
            printInfo.start();
        }
    }
}
