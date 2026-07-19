/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author NgoAnhHuy
 */
public class SmartDevice extends Device {
    private String connectionType;

    public SmartDevice(int deviceId, String deviceName, int power, String connectionType) {
        super(deviceId, deviceName, power);
        this.connectionType = connectionType;
    }

    public int getEnergyUsage() {
        if (this.power <= 0) {
            return 0;
        }

        if (this.connectionType != null && this.connectionType.equalsIgnoreCase("WiFi")) {
            return this.power * 24;
        } else if (this.connectionType != null && this.connectionType.equalsIgnoreCase("Bluetooth")) {
            return this.power * 12;
        } else {
            return this.power * 6;
        }
    }

    @Override
    public String toString() {
        return this.deviceId + "-" + this.deviceName + "-" + this.power + "-" + this.connectionType + "-" + getEnergyUsage();
    }
}
