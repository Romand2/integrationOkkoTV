package connectsdk.service.config;

import org.json.JSONException;
import org.json.JSONObject;

public class NetcastTVService extends ServiceConfig {
    public static final String KEY_PAIRING = "pairingKey";
    String pairingKey;

    public NetcastTVService(String serviceUUID) {
        super(serviceUUID);
    }

    public NetcastTVService(String serviceUUID, String pairingKey) {
        super(serviceUUID);
        this.pairingKey = pairingKey;
    }

    public NetcastTVService(JSONObject json) {
        super(json);

        pairingKey = json.optString(KEY_PAIRING, null);
    }

    public String getPairingKey() {
        return pairingKey;
    }

    public void setPairingKey(String pairingKey) {
        this.pairingKey = pairingKey;
        notifyUpdate();
    }

    @Override
    public JSONObject toJSONObject() {
        JSONObject jsonObj = super.toJSONObject();

        try {
            jsonObj.put(KEY_PAIRING, pairingKey);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObj;
    }

}