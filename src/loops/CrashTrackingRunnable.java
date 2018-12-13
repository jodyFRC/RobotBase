package loops;

public abstract class CrashTrackingRunnable implements Runnable {

    @Override
    public final void run() {
        try {
            runCrashTracked();
        } catch (Throwable t) {
            System.out.println(t.getMessage());
            throw t;
        }
    }

    public abstract void runCrashTracked();
}