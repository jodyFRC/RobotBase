package loops;

public class Scheduler {

    CrashTrackingRunnable runnable;
    boolean threadRunning = false;
    Thread thread;
    long period;

    public Scheduler(CrashTrackingRunnable runnable_) {
        runnable = runnable_;
        thread = new Thread() {
            public void run() {
                while(true) {
                    if(threadRunning) {
                        runnable_.run();
                        try {
                            Thread.sleep(period);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        thread.setPriority(Thread.MAX_PRIORITY);
    }

    public synchronized void startPeriodic(double _period) {
        threadRunning = true;
        period = (long)(_period * 1000);
        thread.start();
    }

    //Pseudo "Thread Safe"
    public synchronized void stop() {
        threadRunning = false;
        thread.stop();
    }
}