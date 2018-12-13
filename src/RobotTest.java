import loops.Looper;
import subsystems.ExampleSubsystem;

import java.util.Arrays;

public class RobotTest {
    public static void main(String[] args) throws Exception {
        new RobotTest().initTest();
    }

    public void initTest() throws Exception {
        SubsystemManager mSubsystemManager = new SubsystemManager(
                Arrays.asList(
                        ExampleSubsystem.getInstance()
                )
        );

        Looper mLooper = new Looper();
        mSubsystemManager.registerEnabledLoops(mLooper);

        mLooper.start();
        Thread.sleep(1000);
        mLooper.stop();
    }
}
