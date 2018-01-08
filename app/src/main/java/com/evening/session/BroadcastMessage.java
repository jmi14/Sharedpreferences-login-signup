package com.evening.session;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hpfolio.classcodes.R;

public class BroadcastMessage extends AppCompatActivity {

    Button buttonSendMessage;
    EditText editTextTypeMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_message2);

        initWidgets();
    }

    private void initWidgets(){

        buttonSendMessage = (Button)findViewById(R.id.btnSendMessage);
        editTextTypeMessage = (EditText)findViewById(R.id.etMessage);

        buttonSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newMessage = editTextTypeMessage.getText().toString();
                Intent intent = new Intent();
                intent.setAction("com.evening.session_SEND_MSG");
                intent.putExtra("message",newMessage);
                sendBroadcast(intent);
            }
        });
    }
}
