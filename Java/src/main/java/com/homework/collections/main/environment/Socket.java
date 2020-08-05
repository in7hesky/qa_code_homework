package com.homework.collections.main.environment;

import com.homework.collections.main.devices.Device;
import com.homework.collections.main.devices.CompactDevice;

import java.util.ArrayList;
import java.util.List;

public class Socket {
    public static final int CONSUMPTION_LIMIT = 60;

    private int totalConsumption = 0;
    private List<Device> pluggedDevices = new ArrayList<>();

    public int getTotalConsumption() {
        return totalConsumption;
    }

    public List<Device> getPluggedDevices() {
        return pluggedDevices;
    }

    public boolean connectDevice(Device deviceToConnect) {
        if (!(deviceToConnect instanceof CompactDevice && ((CompactDevice) deviceToConnect).isOnBatteries()) &&
                totalConsumption + deviceToConnect.getConsumption() <= CONSUMPTION_LIMIT && !deviceToConnect.isOn()) {
            deviceToConnect.setStage(true);
            this.totalConsumption += deviceToConnect.getConsumption();
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
