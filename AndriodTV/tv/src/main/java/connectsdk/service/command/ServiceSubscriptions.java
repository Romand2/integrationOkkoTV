package connectsdk.service.command;

import java.util.List;

public interface ServiceSubscriptions<T> {
    public void unsubscribe();

    public T addListener(T listener);

    public void removeListener(T listener);

    public List<T> getListeners();
}