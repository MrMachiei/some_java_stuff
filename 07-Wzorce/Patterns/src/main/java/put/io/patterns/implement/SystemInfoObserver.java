package put.io.patterns.implement;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

public class SystemInfoObserver implements SystemStateObserver{
    public void update(SystemMonitor monitor){
        SystemState lastSystemState = monitor.getLastSystemState();
        System.out.println("============================================");
        System.out.println(String.format("CPU Load: %2.2f%%", lastSystemState.getCpu()));
        System.out.println(String.format("CPU temperature: %.2f C", lastSystemState.getCpuTemp()));
        System.out.println(String.format("Available memory: %.2f MB", lastSystemState.getAvailableMemory()));
        System.out.println(String.format("USB devices: %d", lastSystemState.getUsbDevices()));

        // Run garbage collector when out of memory
        if (lastSystemState.getAvailableMemory() < 200.00){
            System.out.println("> Running garbage collector...");
        }

        // Increase CPU cooling if the temperature is to high
        if (lastSystemState.getCpuTemp() > 60.00){
            System.out.println("> Increasing cooling of the CPU...");
        }
    }



}
