
        package connectsdk.helper;

        import java.io.IOException;
        import java.net.InetAddress;
        import java.net.UnknownHostException;

public class DeviceServiceRichability {
    private static final int TIMEOUT = 10000;
    private InetAddress ipAddress;
    private Thread testThread;

    private DeviceServiceReachabilityListener listener;

    public DeviceServiceRichability() { }

    public DeviceServiceRichability(InetAddress ipAddress) {
        this.ipAddress = ipAddress;
    }

    public DeviceServiceRichability(InetAddress ipAddress, DeviceServiceReachabilityListener listener) {
        this.ipAddress = ipAddress;
        this.listener = listener;
    }

    public static DeviceServiceRichability getReachability(InetAddress ipAddress, DeviceServiceReachabilityListener listener) {
        return new DeviceServiceRichability(ipAddress, listener);
    }

    public static DeviceServiceRichability getReachability(final String ipAddress, DeviceServiceReachabilityListener listener) {
        InetAddress addr;
        try {
            addr = InetAddress.getByName(ipAddress);
        } catch (UnknownHostException e) {
            return null;
        }
        return getReachability(addr, listener);
    }

    public InetAddress getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(InetAddress ipAddress) {
        this.ipAddress = ipAddress;
    }

    public boolean isRunning() {
        return testThread != null && testThread.isAlive();
    }

    public DeviceServiceReachabilityListener getListener() {
        return listener;
    }

    public void setListener(DeviceServiceReachabilityListener listener) {
        this.listener = listener;
    }

    public void start() {
        if (isRunning())
            return;

        testThread = new Thread(testReachability);
        testThread.start();
    }

    public void stop() {
        if (!isRunning())
            return;

        testThread.interrupt();
        testThread = null;
    }

    private void unreachable() {
        stop();

        if (listener != null)
            listener.onLoseReachability(this);
    }

    private Runnable testReachability = new Runnable() {

        @Override
        public void run() {
            try {
                while (true) {
                    if (!ipAddress.isReachable(TIMEOUT))
                        unreachable();
                    Thread.sleep(TIMEOUT);
                }
            } catch (IOException e) {
                unreachable();
            } catch (InterruptedException e) { }
        }
    };

    public interface DeviceServiceReachabilityListener {
        public void onLoseReachability(DeviceServiceRichability reachability);
    }
}

