package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ThreadTimer extends Thread {
    private TimerObject timer;
    private Lock locker;
    private Condition condition;

    public ThreadTimer(TimerObject timer, Lock locker, Condition condition) {
        this.timer = timer;
        this.locker = locker;
        this.condition = condition;
    }

    @Override
    public void run() {
        int timeToWork = 100;
        for (int i = 0; i < timeToWork; ++i) {
            timer.increaseTimer();
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
