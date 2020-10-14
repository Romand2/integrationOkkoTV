
        package connectsdk.dicsovery;

        import java.util.List;



public interface DiscoveryProvider {
    public final static int RESCAN_INTERVAL = 10000;
    public final static int RESCAN_ATTEMPTS = 6;
    public final static int TIMEOUT = RESCAN_INTERVAL * RESCAN_ATTEMPTS;

    /**
     * Starts the DiscoveryProvider.
     */
    public void start();

    /**
     * Stops the DiscoveryProvider.
     */
    public void stop();

    /**
     * Restarts the DiscoveryProvider.
     */
    public void restart();

    /**
     * Sends out discovery query without a full restart
     */
    public void rescan();

    /**
     * Resets the DiscoveryProvider.
     */
    public void reset();

    /** Adds a DiscoveryProviderListener, which should be the DiscoveryManager */
    public void addListener(DiscoveryProviderListener listener);

    /** Removes a DiscoveryProviderListener. */
    public void removeListener(DiscoveryProviderListener listener);

    /**
     * Adds a device filter for a particular DeviceService.
     *
     * @param filter filter to be used for discovering a particular DeviceService
     */
    public void addDeviceFilter(DiscoveryFilter filter);

    /**
     * Removes a device filter for a particular DeviceService. If the DiscoveryProvider has no other devices to be searching for, the DiscoveryProvider will be stopped and de-referenced.
     *
     * @param filter filter to be used for discovering a particular DeviceService
     */
    public void removeDeviceFilter(DiscoveryFilter filter);

    /**
     * Set filters for a list of particular DeviceServices
     *
     * @param filters filters to be used for discovering a list of particular DeviceServices
     */
    public void setFilters(List<DiscoveryFilter> filters);

    /**
     * Whether or not the DiscoveryProvider has any services it is supposed to be searching for. If YES, then the DiscoveryProvider will be stopped and de-referenced by the DiscoveryManager.
     */
    public boolean isEmpty();
}

