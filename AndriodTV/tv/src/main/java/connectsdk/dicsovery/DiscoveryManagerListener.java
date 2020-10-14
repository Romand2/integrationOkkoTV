
        package connectsdk.dicsovery;

        import connectsdk.device.ConnectDevice;
        import connectsdk.service.command.ServiceCommandError;


public interface DiscoveryManagerListener {


    public void onDeviceAdded(DiscoveryManager manager, ConnectDevice device);


    public void onDeviceUpdated(DiscoveryManager manager, ConnectDevice device);


    public void onDeviceRemoved(DiscoveryManager manager, ConnectDevice device);

    public void onDiscoveryFailed(DiscoveryManager manager, ServiceCommandError error);
}

