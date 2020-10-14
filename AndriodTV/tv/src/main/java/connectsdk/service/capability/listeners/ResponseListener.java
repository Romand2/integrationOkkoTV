
        package connectsdk.service.capability.listeners;


public interface ResponseListener<T> extends ErrorListener {


    abstract public void onSuccess(T object);
}
