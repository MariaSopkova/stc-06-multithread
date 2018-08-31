package wait_notify;

public class TimerObject {
    private int timeFromStart = 0;

    public synchronized int getTimeFromStart() {
        return timeFromStart;
    }

    public synchronized void increaseTimer() {
        ++timeFromStart;
        System.out.println(this);
        notifyAll();
    }

    @Override
    public String toString() {
        return "timeFromStart :" + timeFromStart;
    }
}
