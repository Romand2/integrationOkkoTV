package connectsdk.service.sessions;

public interface WebAppSessionListener {


    public void onReceiveMessage(WebAppSession webAppSession, Object message);


    public void onWebAppSessionDisconnect(WebAppSession webAppSession);
}