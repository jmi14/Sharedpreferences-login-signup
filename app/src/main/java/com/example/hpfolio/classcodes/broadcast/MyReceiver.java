package com.example.hpfolio.classcodes.broadcast;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.example.hpfolio.classcodes.R;


public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
//        // TODO: This method is called when the BroadcastReceiver is receiving
//        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");

//        Toast.makeText(context, "some message is arrived", Toast.LENGTH_SHORT).show();

        notifyOnMessageReceive(context,intent);
    }

    private void notifyOnMessageReceive(Context context,Intent intent) {
        Bundle bundle = intent.getExtras();
        String newMessage = bundle.getString("message");

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle("Notification");
        builder.setContentText(newMessage);
        builder.setSmallIcon(R.drawable.ic_action_name);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());
    }
}
