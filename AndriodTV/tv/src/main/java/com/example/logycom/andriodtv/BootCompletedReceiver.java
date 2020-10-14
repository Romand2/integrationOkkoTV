package com.example.logycom.andriodtv;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.Context;

public class BootCompletedReceiver extends BroadcastReceiver {
    public BootCompletedReceiver() {
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            // В будущем код будет тут .. рассмотрел 2 варианта
        }
    }
}
