package subsystems;

import loops.ILooper;

public abstract class Subsystem {
    public void writeToLog() {
    }

    // Optional design pattern for caching periodic reads to avoid hammering the HAL/CAN.
    public void readPeriodicInputs() {
    }

    // Optional design pattern for caching periodic writes to avoid hammering the HAL/CAN.
    public void writePeriodicOutputs() {
    }

    public abstract boolean checkSystem();

    public abstract void outputTelemetry();

    public abstract void stop();

    public void zeroSensors() {
    }

    public void registerEnabledLoops(ILooper enabledLooper) {
    }
}