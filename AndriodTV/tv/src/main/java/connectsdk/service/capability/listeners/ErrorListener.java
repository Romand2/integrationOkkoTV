package connectsdk.service.capability.listeners;

import connectsdk.service.command.ServiceCommandError;


public interface ErrorListener {


    public void onError(ServiceCommandError error);
}