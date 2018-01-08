package com.example.hpfolio.classcodes.broadcast;

import android.app.AlertDialog;
import android.app.Notification;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hpfolio.classcodes.R;

public class BroadcastMessage extends AppCompatActivity {
    String newMessage;
    EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_message);

        init();
    }

    private void init() {

        Button buttonMessage = (Button) findViewById(R.id.btnMessage);
        editTextMessage = (EditText) findViewById(R.id.etMessage);


        buttonMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });


    }

    private void sendMessage() {
        newMessage = editTextMessage.getText().toString();
        Intent intent = new Intent();
        intent.setAction("com.example.hpfolio.classcodes.broadcast");
        intent.putExtra("message", newMessage);
        sendBroadcast(intent);
    }

}
