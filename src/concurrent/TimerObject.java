package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class TimerObject {
    private int timeFromStart = 0;
    private Lock locker;
    private Condition condition;

    public TimerObject(Lock locker, Condition condition) {
        this.locker = locker;
        this.condition = condition;
    }

    public TimerObject() {
    }

    public int getTimeFromStart() {
        return timeFromStart;
    }

    public void increaseTimer() {
        locker.lock();
        ++timeFromStart;
        System.out.println(this);
        condition.signalAll();
        locker.unlock();
    }

    @Override
    public String toString() {
        return "timeFromStart :" + timeFromStart;
    }
}
