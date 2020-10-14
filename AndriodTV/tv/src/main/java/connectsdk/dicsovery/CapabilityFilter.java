
        package connectsdk.dicsovery;

        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.List;

public class CapabilityFilter {

    /**
     * List of capabilities required by this filter. This property is readonly -- use the addCapability or addCapabilities to build this object.
     */
    public List<String> capabilities = new ArrayList<String>();

    /**
     * Create an empty CapabilityFilter.
     */
    public CapabilityFilter() {
    }

    /**
     * Create a CapabilityFilter with the given array of required capabilities.
     *
     * @param capabilities Capabilities to be added to the new filter
     */
    public CapabilityFilter(String ... capabilities) {
        for (String capability : capabilities) {
            addCapability(capability);
        }
    }

    /**
     * Create a CapabilityFilter with the given array of required capabilities.
     *
     * @param capabilities List of capability names (see capability class files for String constants)
     */
    public CapabilityFilter(List<String> capabilities) {
        addCapabilities(capabilities);
    }

    /**
     * Add a required capability to the filter.
     *
     * @param capability Capability name to add (see capability class files for String constants)
     */
    public void addCapability(String capability) {
        capabilities.add(capability);
    }

    /**
     * Add array of required capabilities to the filter. (see capability class files for String constants)
     *
     * @param capabilities List of capability names
     */
    public void addCapabilities(List<String> capabilities) {
        this.capabilities.addAll(capabilities);
    }

    /**
     * Add array of required capabilities to the filter. (see capability classes files for String constants)
     *
     * @param capabilities String[] of capability names
     */
    public void addCapabilities(String... capabilities) {
        Collections.addAll(this.capabilities, capabilities);
    }
}
