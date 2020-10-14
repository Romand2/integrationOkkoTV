
        package connectsdk.dicsovery;

        import connectsdk.service.command.ServiceCommandError;
        import connectsdk.service.config.ServiceDisc;

/**
 * The DiscoveryProviderListener is mechanism for passing service information to the DiscoveryManager. You likely will not be using the DiscoveryProviderListener class directly, as DiscoveryManager acts as a listener to all of the DiscoveryProviders.
 */
public interface DiscoveryProviderListener {


    public void onServiceAdded(DiscoveryProvider provider, ServiceDisc serviceDescription);


    public void onServiceRemoved(DiscoveryProvider provider, ServiceDisc serviceDescription);


    public void onServiceDiscoveryFailed(DiscoveryProvider provider, ServiceCommandError error);
}
