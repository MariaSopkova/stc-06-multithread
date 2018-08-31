package wait_notify;

public class ThreadPrintInfo extends Thread {
    private TimerObject timeFromStart;
    private String threadName;
    private int printTime;

    public ThreadPrintInfo(String threadName, int printTime, TimerObject timeFromStart) {
        this.threadName = threadName;
        this.printTime = printTime;
        this.timeFromStart = timeFromStart;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (timeFromStart) {
                try {
                    timeFromStart.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (timeFromStart.getTimeFromStart() % printTime == 0) {
                    System.out.println(threadName);
                }
            }
        }
    }
}
