package com.example.spaces;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class SpacesBooking extends AppCompatActivity {
    public int mCounter = 0;

    ImageView pageImage;
    Button plusBtn;
    Button minusBtn;
    Button testButton;

    TextView spacesChosen;
    TextView booking;


    ConstraintLayout SpacesBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spaces_booking);


        spacesChosen = findViewById(R.id.spacesCounter);


        plusBtn = findViewById(R.id.plusBtn);
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                if (mCounter < 10) {
                    mCounter++;
                    spacesChosen.setText(Integer.toString(mCounter));
                }
            }
        });

        minusBtn = findViewById(R.id.minusBtn);
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                if (mCounter > 0) {
                    mCounter--;
                    spacesChosen.setText(Integer.toString(mCounter));
                }
            }
        });

    }
}