
        package connectsdk.device;

        import java.util.HashMap;

        import connectsdk.dicsovery.DiscoveryManager;

        import android.content.Context;
        import android.content.pm.ApplicationInfo;
        import android.graphics.Color;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.TextView;


public class DevicePickerAdapter extends ArrayAdapter<ConnectDevice> {
    int resource, textViewResourceId, subTextViewResourceId;
    HashMap<String, ConnectDevice> currentDevices = new HashMap<String, ConnectDevice>();
    Context context;

    DevicePickerAdapter(Context context) {
        this(context, android.R.layout.simple_list_item_2);
    }

    DevicePickerAdapter(Context context, int resource) {
        this(context, resource, android.R.id.text1, android.R.id.text2);
    }

    DevicePickerAdapter(Context context, int resource, int textViewResourceId, int subTextViewResourceId) {
        super(context, resource, textViewResourceId);
        this.context = context;
        this.resource = resource;
        this.textViewResourceId = textViewResourceId;
        this.subTextViewResourceId = subTextViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (convertView == null) {
            view = View.inflate(getContext(), resource, null);
        }

        ConnectDevice device = this.getItem(position);
        String text;
        if (device.getFriendlyName() != null) {
            text = device.getFriendlyName();
        }
        else {
            text = device.getModelName();
        }

        view.setBackgroundColor(Color.BLACK);

        TextView textView = (TextView) view.findViewById(textViewResourceId);
        textView.setText(text);
        textView.setTextColor(Color.WHITE);

        boolean isDebuggable =  (0 != (context.getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE));
        boolean hasNoFilters = DiscoveryManager.getInstance().getCapabilityFilters().size() == 0;

        String serviceNames = device.getConnectedServiceNames();
        boolean hasServiceNames = (serviceNames != null && serviceNames.length() > 0);

        boolean shouldShowServiceNames = hasServiceNames && (isDebuggable || hasNoFilters);

        TextView subTextView = (TextView) view.findViewById(subTextViewResourceId);

        if (shouldShowServiceNames) {
            subTextView.setText(serviceNames);
            subTextView.setTextColor(Color.WHITE);
        } else {
            subTextView.setText(null);
        }

        return view;
    }
}
