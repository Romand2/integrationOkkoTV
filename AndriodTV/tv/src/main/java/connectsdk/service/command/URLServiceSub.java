

        package connectsdk.service.command;

        import java.util.ArrayList;
        import java.util.List;

        import org.json.JSONObject;

        import connectsdk.service.capability.listeners.ResponseListener;

/**
 * Internal implementation of ServiceSubscription for URL-based commands
 */
public class URLServiceSub <T extends ResponseListener<?>> extends ServiceCommand<T> implements ServiceSubscriptions<T> {
    private List<T> listeners = new ArrayList<T>();

    public URLServiceSub(ServiceCommandProcessor processor, String uri, JSONObject payload, ResponseListener<Object> listener) {
        super(processor, uri, payload, listener);
    }

    public URLServiceSub(ServiceCommandProcessor processor, String uri, JSONObject payload, boolean isWebOS, ResponseListener<Object> listener) {
        super(processor, uri, payload, isWebOS, listener);

        if (isWebOS)
            httpMethod = "subscribe";
    }

    public void send() {
        this.subscribe();
    }

    public void subscribe() {
        if (!(httpMethod.equalsIgnoreCase(TYPE_GET)
                || httpMethod.equalsIgnoreCase(TYPE_POST))) {
            httpMethod = "subscribe";
        }
        processor.sendCommand(this);
    }

    public void unsubscribe() {
        processor.unsubscribe(this);
    }

    public T addListener(T listener) {
        listeners.add(listener);

        return listener;
    }

    public void removeListener(T listener) {
        listeners.remove(listener);
    }

    public void removeListeners() {
        listeners.clear();
    }

    public List<T> getListeners() {
        return listeners;
    }
}