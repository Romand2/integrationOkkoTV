package com.example.logycom.andriodtv;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.Context;


public class AutoStart extends BroadcastReceiver {

    @Override
    public void onReceive (Context context , Intent intent) {
    Intent intent1 =new Intent(context , MainActivity.class);
    intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent1);
    }

}

