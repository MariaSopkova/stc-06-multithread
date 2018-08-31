package wait_notify;

public class ThreadTimer extends Thread {
    private TimerObject timer;

    public ThreadTimer(TimerObject timer) {
        this.timer = timer;
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
