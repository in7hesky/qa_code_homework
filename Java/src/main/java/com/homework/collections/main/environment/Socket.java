package com.homework.collections.main.environment;

import com.homework.collections.main.devices.Device;
import com.homework.collections.main.devices.NormalDevice;

import java.util.ArrayList;
import java.util.List;

public class Socket {
    public static final int CONSUMPTION_LIMIT = 100;

    private int totalConsumption = 0;
    private List<Device> pluggedDevices = new ArrayList<>();

    public int getTotalConsumption() {
        return totalConsumption;
    }

    public List<Device> getPluggedDevices() {
        return pluggedDevices;
    }

    public boolean connectDevice(Device deviceToConnect) {
        if (deviceToConnect instanceof NormalDevice)
            if (((NormalDevice) deviceToConnect).isOnBatteries())
                return false;

        if (totalConsumption + deviceToConnect.getConsumption() < CONSUMPTION_LIMIT && !deviceToConnect.isOn()) {
            deviceToConnect.setStage(true);
            totalConsumption += deviceToConnect.getConsumption();
            this.pluggedDevices.add(deviceToConnect);
            return true;
        }

        return false;
    }

    public void disconnectDevice(Device deviceToDisconnect) {
        deviceToDisconnect.setStage(false);
        totalConsumption -= deviceToDisconnect.getConsumption();
        pluggedDevices.remove(deviceToDisconnect);
    }


}
