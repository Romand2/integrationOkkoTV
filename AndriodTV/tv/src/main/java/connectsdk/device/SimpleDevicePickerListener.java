

        package connectsdk.device;

public interface SimpleDevicePickerListener extends DevicePickerListener {
    /**
     * Called when the user selects a device.
     * This callback can be used to prepare the device (request permissions, etc)
     * just before attempting to connect.
     *
     * @param device
     */
    public void onPrepareDevice(ConnectDevice device);

    /**
     * Called when device is ready to use (requested permissions approved).
     * @param device
     */
    public void onPickDevice(ConnectDevice device);


    public void onPickDeviceFailed(boolean canceled);
}
