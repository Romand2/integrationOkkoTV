package connectsdk.device;

        import org.json.JSONObject;

        import connectsdk.service.config.ServiceConfig;
        import connectsdk.service.config.ServiceDisc;


public interface ConnectDeviceStore {

    /**
     * Add a ConnectableDevice to the ConnectableDeviceStore. If the ConnectableDevice is already stored, it's record will be updated.
     *
     * @param device ConnectableDevice to add to the ConnectableDeviceStore
     */
    public void addDevice(ConnectDevice device);

    /**
     * Removes a ConnectableDevice's record from the ConnectableDeviceStore.
     *
     * @param device ConnectableDevice to remove from the ConnectableDeviceStore
     */
    public void removeDevice(ConnectDevice device);

    /**
     * Updates a ConnectableDevice's record in the ConnectableDeviceStore.
     *
     * @param device ConnectableDevice to update in the ConnectableDeviceStore
     */
    public void updateDevice(ConnectDevice device);


    public JSONObject getStoredDevices();


    public ConnectDevice getDevice(String uuid);


    public ServiceConfig getServiceConfig(ServiceDisc serviceDescription);


    public void removeAll();
}
