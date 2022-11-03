package com.example.spaces;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.os.Bundle;
import android.widget.TextView;

public class bookingNotification extends AppCompatActivity {
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_notification);

        textview = findViewById(R.id.textview);

        NotificationManager manager = (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);

        manager.cancelAll();

        if (getIntent().hasExtra("yes")){
            textview.setText("Accepted!");
        } else  if (getIntent().hasExtra("no")){
            textview.setText("Denied!");
        }


    }
}