package com.evening.session;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        receiveMessage(context, intent);
    }

    private void receiveMessage(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();
        String newMessage = bundle.getString("message");
        Toast.makeText(context, newMessage, Toast.LENGTH_SHORT).show();
    }
}
