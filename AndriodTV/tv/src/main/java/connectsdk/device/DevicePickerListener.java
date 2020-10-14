
package connectsdk.device;

public interface DevicePickerListener {

    public void onPickDevice(ConnectDevice device);
    public void onPickDeviceFailed(boolean canceled);
}
