/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author NgoAnhHuy
 */
public class Device {
   
    protected int deviceId;
    protected String deviceName;
    protected int power;

   
    public Device(int deviceId, String deviceName, int power) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.power = power;
    }
}
